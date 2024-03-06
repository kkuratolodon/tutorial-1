Muhammad Irfan Firmansyah <br>
2206816102 <br>
Adpro-B <br>

# Modul 4
## Refleksi
1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests. <br><br>
Prosedur TDD sangat membantu dalam pengerjaan karena memiliki alur yang baik. Alur ini terbagi menjadi tiga bagian: [RED], [GREEN], dan [REFACTOR]. Pembagian ini membantu dalam mengimplementasikan class karena sebelum class dibuat, semua kasus baik dan buruk sudah di-handle terlebih dahulu. Hal ini memastikan kode yang dihasilkan lebih aman dan meminimalisir error dan bug. Selain itu, TDD juga memudahkan proses refactor karena kode yang dihasilkan lebih terstruktur dan mudah dipahami.

2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
<br><br>Pada unit test yang telah saya buat dalam tutorial ini, saya telah memenuhi prinsip F.I.R.S.T. Algoritma yang dikembangkan fokus pada satu metode tertentu dan tidak ikut campur dengan metode lain. Selain itu, pada pengujian layanan, saya telah menggunakan penggantian objek (mock) sehingga tidak ada dampak pada kode aslinya. Setiap tes juga dilengkapi dengan pernyataan (assertion) untuk memastikan bahwa segala kemungkinan telah diperiksa secara menyeluruh. Tentu saja, setiap tes dirancang untuk mencakup sebanyak mungkin skenario "happy" dan "unhappy" dari metode yang sedang diuji.

# Modul 3

## Refleksi
1. Explain what principles you apply to your project!
- Single Responsibility Principle (SRP): SRP adalah prinsip di mana 1 module hanya mempunyai 1 responsibility. Oleh karena itu, saya memisahkan CarController dan ProductController menjadi 2 file terpisah.
- Liskov Substitution Principle (LSP): LSP adalah prinsip di mana jika B adalah subclass A, maka object dari B dapat melakukan semua method di A dengan benar. Oleh karena itu, saya menghapus "extends" di CarController, karena asumsi saya, Car independent dengan Product sehingga object CarController tidak seharusnya memanggil method-method di ProductController
- Interface Segregation Principle (ISP): ISP adalah prinsip di mana interface lebih baik hanya memuat method-method yang dibutuhkan oleh Class yang mengimplementasinya. Menurut saya, hal ini sudah diterapkan di kode saya karena semua method di interface ProductService dan CarService memang dipakai semua di class Implnya.
- Dependency Inversion Principle (DIP): DIP adalah prinsip di mana sebuah class seharusnya bergantung terhadap interface atau abstract class daripada langsung terhadap class concretenya. Oleh karena itu, saya mengubah kode di `CarController.java` dari `private CarServiceImpl carservice;` menjadi `private CarService carservice;`, agar yang CarController memakai interfacenya bukan class yang concrete.

 2. Explain the advantages of applying SOLID principles to your project with examples.
- Kode lebih aman saat mendapat update:<br>
  Dengan menerapkan Single Responsibility Principle (SRP) dan Open/Closed Principle (OCP), kode akan menjadi lebih modular. Setiap komponen memiliki tanggung jawab yang jelas, dan perubahan pada satu bagian tidak akan merusak atau memengaruhi bagian lain. 
- Kode yang Lebih Maintainable:<br>
  Keberlanjutan (maintainability) kode sangat penting. Dengan menerapkan SOLID principles, kode akan lebih mudah dipahami karena setiap komponen memiliki tujuan spesifik dan terfokus. Ini membuat pemeliharaan kode menjadi lebih efisien. 
- Kode yang Lebih Fleksibel dan Dapat Digunakan Kembali:<br>
  Dengan menerapkan Liskov Substitution Principle (LSP) dan Dependency Inversion Principle (DIP), kode menjadi lebih fleksibel. Kode yang berfokus pada abstraksi dan mengurangi ketergantungan langsung antar komponen membuatnya lebih mudah untuk disesuaikan dengan perubahan.

3. Explain the disadvantages of not applying SOLID principles to your project with examples.
- Proses Modifikasi yang Sulit: <br>
  Kode yang tidak menerapkan SOLID principles bisa memiliki kendala besar ketika melakukan modifikasi atau pembuatan fitur baru. Misalnya, jika Anda mengubah suatu bagian kecil dari kode, Anda mungkin khawatir karena bagian kecil tersebut berdampak pada banyak kode lain. Hal ini dapat membuat proses pengembangan lebih rumit dan meningkatkan risiko error.
- Ketergantungan yang Tinggi dan Risiko Kerusakan Kode: <br>
  Tanpa menerapkan prinsip Dependency Inversion, ketergantungan langsung pada implementasi spesifik dapat menyebabkan kerusakan pada kode. Misalnya, jika tidak mengikuti prinsip ini dan bergantung langsung pada CarServiceImpl, perubahan dalam CarServiceImpl seperti perubahan metode atau struktur kelas dapat merusak file CarController. Dengan menerapkan prinsip DIP dan menggunakan interface CarService, risiko kerusakan dapat diminimalkan.
- Kesulitan Identifikasi Bug dan Kesalahan: <br>
  Tanpa prinsip-prinsip SOLID, risiko untuk memasukkan bug atau kesalahan dalam kode menjadi lebih tinggi. Ketidakjelasan dalam tanggung jawab komponen, ketidakstabilan struktur kode, dan ketergantungan yang tinggi dapat mengakibatkan pengembang membuat kesalahan yang sulit diidentifikasi dan diperbaiki.

# Modul 2

## Refleksi

### 1. Code Improvement
   - Saya menemukan beberapa isu terkait kode, seperti impor yang tidak digunakan. Oleh karena itu, saya menghapus impor yang tidak diperlukan.
   - Saya juga mengubah visibility dari semua class testing dari public menjadi default.
   - Terdapat variabel yang seharusnya tidak dideklarasikan sebagai static, sehingga saya menghapus kata kunci static pada variabel tersebut.

### 2. Evaluasi Penerapan CI/CD
   Menurut saya, implementasi CI/CD yang telah saya lakukan sesuai dengan prinsip-prinsip CI/CD. Saya telah menerapkan Continuous Integration (CI) untuk memastikan setiap perubahan tidak merusak fungsionalitas dan memenuhi standar kode yang telah ditetapkan. Selain itu, Continuous Delivery (CD) juga diterapkan untuk mengelola proses deployment.

   Beberapa workflow yang telah saya implementasikan meliputi:
   - `ci.yml`: Melakukan tes otomatis saat ada push atau pull.
   - `scorecard.yml` dan `sonarcloud.yml`: Melakukan pengecekan kebersihan kode.

   Di samping workflow tersebut, saya juga menggunakan Koyeb sebagai Platform as a Service (PaaS) untuk deployment. Platform ini menyediakan sejumlah CI/CD built-in untuk otomatisasi setiap kali terjadi push atau pull request dari suatu branch.
      
# Modul 1
## Refleksi 1
Dari segi prinsip clean code, saya telah menggunakan berbagai variabel yang mudah dipahami, seperti "editedProduct" yang merupakan produk setelah diedit. Selain itu, saya juga menggunakan nama fungsi yang jelas, seperti "findById" untuk mencari produk berdasarkan id. Menurut saya, untuk nama fungsi dan variabel yang sudah jelas tidak perlu menambahkan komenta. Fungsi-fungsi yang dibuat bersifat straightforward, dengan masing-masing berfungsi untuk tujuan tertentu, seperti fungsi "delete" untuk menghapus item dan "edit" untuk mengedit nama dan kuantitas.

Selanjutnya untuk secure coding ada beberapa kelemahan yang saya temui, yaitu tidak memvalidasi suatu input. Contohnya, user dapat menginput bilangan negatif di input kuantitas produnya. Selain itu, terdapat kelemahan pada URL yang digunakan untuk mengedit item, di mana ID produk dipasssing melalui URL, sehingga user dapat melihat id tersebut.

## Refleksi 2
1. Karena ini adalah pengalaman yang baru untuk saya membuat testing, terdapat beberapa kesulitan. Namun, overall unit test membuat kita dapat lebih mudah mengetes semua kode daripada tes manual. Terkait berapa banyak batas minimum unit test yang dibuat untuk suatu program tidaklah ada standar pasti. Menurut saya, yang penting test tersebut sudah mengcover semua kasus yang perlu diuji. Code coverage adalah metrik yang membantu memahami seberapa banyak kode sumber yang telah diuji. Meskipun mencapai 100% code coverage merupakan tujuan positif, hal tersebut tidak menjamin bahwa kode tidak memiliki bug atau kesalahan. Code coverage lebih mengindikasikan sejauh mana kode dieksekusi selama pengujian, tetapi tidak menjamin kebenaran logika atau fungsionalitas program.
   
2. Menurut saya, kasus yang dijelaskan di atas dianggap tidak efisien. Perhatikan bahwa kedua functional test yang hampir serupa menggunakan setup procedures dan instance variable yang sama, mengakibatkan pengurangan kebersihan kode yang sebelumnya telah dibuat semaksimal mungkin.<br><br>Issue yang ditemukan adalah adanya repetisi dalam menanggapi perubahan pada halaman HTML. Setiap perubahan pada halaman HTML memerlukan modifikasi pada kedua kelas Java yang hampir identik, menciptakan kerumitan yang tidak perlu. Solusi yang disarankan adalah menggabungkan kedua fungsi setup untuk menghindari repetisi dan menjaga kebersihan kode. Dengan menggabungkan kedua fungsi tersebut, pengelolaan setup tidak lagi repetitif, menjaga kebersihan kode tetap terjaga. Selain itu, penggabungan setup fungsi juga akan mempermudah penanganan pergantian elemen atau isi dari halaman HTML yang dibuat.
