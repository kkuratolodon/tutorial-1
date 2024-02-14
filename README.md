# Modul 2
Muhammad Irfan Firmansyah <br>
2206816102 <br>
Adpro-B <br>

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
