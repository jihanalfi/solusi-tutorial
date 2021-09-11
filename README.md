# Solusi Tutorial APAP 2021/2022
Solusi setiap tutorial mata kuliah APAP 2021/2022 untuk topik KebunSafari, PergiPergi, dan 21Cineplux.

Solusi kedua topik akan dibedakan berdasarkan branch.

---

## Jawaban Catatan Tutorial 1
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

   Issue Tracker adalah sebuah fitur yang dapat membantu *developer* untuk melakukan *tracking* terhadap masalah-masalah yang ada dalam suatu *repository*. Issue Tracker dapat digunakan untuk mendapatkan *feedback* dari pengguna atau *collaborator*, melaporkan *bug* yang ada dalam kode, serta membantu *developer* mencatat dan memprioritaskan masalah-masalah yang ada. Secara umum, Issue Tracker dapat digunakan sebagai *to-do list* agar *developer* dapat mendiskusikan dan melakukan perbaikan terhadap kode.

2. Apa perbedaan dari git merge dan git merge --squash?

   Saat kita melakukan `git merge` terhadap suatu *branch* ke *branch* lainnya, misalnya dalam suatu kasus sebuah *branch* Feature ke *branch* Master, maka semua commit yang ada pada branch Feature akan masuk ke dalam *history commit* yang ada pada *branch* Master. Saat kita melakukan `git merge --squash`, maka hanya akan ada satu commit yang mewakilkan *branch* Feature yang akan masuk ke dalam *branch* Master, sehingga akan menghasilkan *history commit* yang lebih rapi.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?

   Version Control System membantu merekam perubahan yang terjadi pada kode aplikasi. Dengan bantuan Version Control System, kolaborasi dalam membuat aplikasi juga akan lebih mudah, karena setiap *developer* dapat memiliki versi aplikasinya tersendiri dalam *local environment*-nya, yang pada nantinya dapat digabungkan menjadi satu dengan **merging**. Selain itu, apabila suatu versi terdapat masalah, maka Version Control System memberikan kemampuan bagi *developer* untuk membandingkan versi tersebut dengan versi sebelum-sebelumnya, sehingga masalah yang muncul dapat teratasi dengan cepat.

### Spring
4. Apa itu library & dependency?

   Library adalah suatu kumpulan kode yang dikompilasikan dan disimpan dalam suatu *file*. *File* tersebut dapat digunakan oleh *developer* untuk membuat suatu aplikasi. Pada umumnya, library berisi kumpulan-kumpulan *function* dan *method* yang dapat dipanggil sesuai dengan kebutuhan. Fungsi-fungsi tersebut juga dapat di-*override* agar dapat disesuaikan dengan kebutuhan. Dengan bantuan library, beban kerja seorang *developer* dapat berkurang karena tidak perlu fokus terhadap pembuatan *method* tertentu. Dependency adalah suatu istilah dimana suatu perangkat lunak bergantung pada perangkat lunak lainnya untuk berjalan. Jika dependency dari suatu perangkat lunak belum ada atau belum di-*install*, maka perangkat lunak tersebut tidak bisa berjalan dengan semestinya.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?

   Apache Maven adalah Java Build Tools yang menggunakan konsep Project Object Model (POM). Maven pada umumnya digunakan untuk aplikasi berbasis Java. Maven menyediakan konfigurasi dan informasi mengenai suatu aplikasi, baik daftar *dependency*, laporan *test coverage*, integrasi dengan Git, dan lainnya. Dalam perkuliahan APAP, Maven digunakan untuk melakukan *project build* dan *testing*. Sebelum menjalankan aplikasi Spring yang telah kita buat, Maven memastikan bahwa semua *dependency* dari aplikasi tersebut sudah ada terlebih dahulu. Beberapa alternatif dari Maven adalah Gradle, Ant, CircleCI, atau Jenkins.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?

   Spring framework dapat digunakan untuk:
   - Membuat REST API
   - Melakukan batch processing
   - Melakukan testing
   - Membuat microservice
   - Mengintegrasikan aplikasi di berbagai platform melalui *cloud*

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
   `@RequestParam` digunakan untuk mengambil data dari parameter hasil *query*, sedangkan `@PathVariable` digunakan untuk mengambil data langsung dari URL. Perbedaan tersebut juga dapat dilihat dari bentuk *path* yang diberikan, dimana URL yang dihasilkan `@RequestParam` berbentuk seperti 
   > http://localhost:8080/foos?id=abc
   
   sedangkan URI yang dihasilkan oleh `@PathVariable` akan berbentuk seperti
   > http://localhost:8080/foos/abc

   `@RequestParam` dapat digunakan jika kita ingin mengimplementasikan suatu nilai *default* apabila parameter yang dibutuhkan tidak ada. `@PathVariable` dapat digunakan jika kita ingin membuat RESTful web services, dimana pada umumnya akan terdapat *value* di dalam URL-nya.