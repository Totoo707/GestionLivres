# GestionLivres 📚

TP Android (Kotlin + Jetpack Compose) – module **Atelier Développement Mobile B3**.  
Backend: **Firebase** (Authentication, Cloud Firestore, Storage).

## Fonctionnalités
- Écran **Login** (Email/Password, validations + popups).
- Écran **Home** : liste des livres (Firestore). Fond **rouge** si non lu, **vert** si lu.
- **Détail** d’un livre : couverture (Storage), titre/auteur/année/description, **checkbox** pour marquer lu ↔ non lu (MAJ Firestore en direct).
- **Logout** (FirebaseAuth).

## Tech
- Kotlin, Jetpack Compose, Navigation
- Firebase Auth / Firestore / Storage (BOM)
- Coil pour le chargement des images
- Architecture simple : `ui/`, `data/`, `util/` (niveau étudiant, commenté)


  
