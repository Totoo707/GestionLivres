package com.example.gestionlivres.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await

class BookRepository(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val storage: FirebaseStorage = FirebaseStorage.getInstance(),
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    private val booksCol = db.collection("books")

    suspend fun getBooks() = booksCol.get().await().documents.map { d ->
        Book(
            id = d.id,
            title = d.getString("title") ?: "",
            author = d.getString("author") ?: "",
            year = (d.getLong("year") ?: 0).toInt(),
            description = d.getString("description") ?: "",
            coverPath = d.getString("coverPath") ?: "",
            read = d.getBoolean("read") ?: false
        )
    }

    suspend fun setRead(bookId: String, read: Boolean) {
        auth.currentUser ?: throw IllegalStateException("User not authenticated")
        booksCol.document(bookId).update("read", read).await()
    }

    suspend fun getCoverUrl(coverPath: String): String =
        if (coverPath.isBlank()) "" else storage.reference.child(coverPath).downloadUrl.await().toString()

    suspend fun seedDemoIfEmpty() {
        if (booksCol.limit(1).get().await().isEmpty) {
            listOf(
                mapOf("title" to "1984","author" to "George Orwell","year" to 1949,"description" to "Dystopia.","coverPath" to "covers/1984.jpg","read" to false),
                mapOf("title" to "The Alchemist","author" to "Paulo Coelho","year" to 1988,"description" to "Quest.","coverPath" to "covers/alchemist.jpg","read" to true)
            ).forEach { booksCol.add(it).await() }
        }
    }
}
