# 🧑‍🎓 StudentManager – Spring Boot Öğrenci Yönetim Sistemi

Bu proje, Spring Boot kullanılarak geliştirilen basit ve güçlü bir öğrenci yönetim sistemidir.  
Öğrenci ekleme, listeleme, silme, güncelleme ve filtreleme işlemleri REST API üzerinden yapılmaktadır.

---

## 🚀 Proje Özeti

- **Backend:** Java 17 + Spring Boot 3.5.0  
- **Veritabanı:** H2 (In-Memory DB)  
- **ORM:** Spring Data JPA + Hibernate  
- **Build Tool:** Maven (Wrapper)  
- **Deploy:** Docker destekli (Render/Railway uyumlu)

---

## 📌 Özellikler

| Özellik                       | Açıklama |
|-------------------------------|----------|
| ✅ Öğrenci Ekleme             | `POST /api/students` |
| ✅ Tüm Öğrencileri Listeleme  | `GET /api/students` |
| ✅ Ada Göre Sıralama         | `GET /api/students/sortedByName` |
| ✅ Yaş Filtresi               | `GET /api/students/filter-by-age?minAge=20` |
| ✅ Öğrenci Güncelleme         | `PUT /api/students/{id}` |
| ✅ Öğrenci Silme              | `DELETE /api/students/{id}` |
| ✅ Thread Örneği             | `GET /api/students/multithreadTest` |
| ✅ Generic Liste Yazdırma     | `GET /api/students/printAll` |
| ✅ Sağlık Kontrolü            | `GET /api/students/health` |

---

## 🔧 Kurulum

### 1. Klonla

```bash
git clone https://github.com/krm345ucr/studentmanager.git
cd studentmanager
