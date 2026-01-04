<div align="center">

[![Paper](https://raw.githubusercontent.com/intergrav/devins-badges/v3/assets/cozy/supported/paper_vector.svg)](https://papermc.io/)
[![Purpur](https://raw.githubusercontent.com/intergrav/devins-badges/v3/assets/cozy/supported/purpur_vector.svg)](https://purpurmc.org/)

</div>

---

## ☠️ Hardcore-On — Plugin Minecraft Hardcore

### 📌 Informations
- **Nom** : Hardcore-On  
- **Version** : 1.0.0  
- **Auteur** : Zyumie (aka Ayano)  
- **API** : Paper / Purpur  
- **Version Minecraft** : 1.20+  

Plugin Hardcore configurable :
- Ban automatique à la mort
- Mode spectateur après la mort
- Messages personnalisables
- Configuration séparée (`hardcore.yml`)

---

## 🔧 Installation

1. Utiliser un serveur **PaperMC** ou **Purpur**.
2. Placer `Hardcore-On.jar` dans le dossier `plugins/`.
3. Démarrer le serveur.
4. Configurer le fichier `hardcore.yml`.
5. Redémarrer ou recharger le serveur.

---

## ⚙️ Configuration (`hardcore.yml`)

```yml
hardcore:
  enabled: true
  ban-on-death: true
  spectator-on-death: false

messages:
  ban-reason: "Mort en mode hardcore"
  kick-message: "Vous êtes banni : mort en hardcore."
```

© 2026 Ayano. Tous droits réservés.
Aucune utilisation, modification ou redistribution sans autorisation explicite.
