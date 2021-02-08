
<a href="https://play.google.com/store/apps/details?id=com.dogan.arabam&hl=tr"><img src="https://arbimg1.mncdn.com/assets/dist/img/tek-tur-large.gif"/>
</a>
# Kazanımlar #

Öncelikle herkese merhabalar, projeye başlamadan önce Kotlin'e adapte olmaya çalıştım. Kotlin'e adapte olduktan sonra(?), sizler tarafından kullanılan kütüphaneleri öğrenmeye başladım. Açıkça söylemem gerekir ise daha önce hiç kullanmadığım kütüphanelerdi bunlar. Sanıyorum sadece Paging ve Hilt kütüphaneleri kaldı. Benim için oldukça yoğun 2 hafta geçti. Yeni bir dile adapte olup, yeni kütüphaneler öğrendim ve kullandım. Bunun yanında MVVM yapısını da öğrenmiş oldum. Aslında ne kadar basic şeyler bilgiğimi fark etmiş oldum ve benim için çok verimli iki haftaydı.

## Kütüphaneler ##
* Room
* RxJava
* Retrofit
* Databinding
* Livedata

# Çıkarımlar #

Kesinlikle Paging projenin başlarında yapılmalı. Sona bırakılmamalı. Sadece paging değil, bir iş ne zaman yapılması gerekiyorsa o zaman yapılmalı. Sanırım ben bundan dolayı projeme ekleyemedim. Tabi ki bahanelerin arkasına sığınmak istemem ancak benim için zorlu bir süreçti. Yeni dil, yeni kütüphaneler ve oldukça fazla hatalar. Üstüne uğraştığım bir diğer nokta ise Room kütüphanesiydi. Converter yazmam gerektiğini Google'da yanlış kelime seçiminden dolayı biraz geç öğrendim. API'den gelen veri ile bizim data classlarımız içerisindeki değişkenlerin aynı olduğu durumlarda @SerializedName kullanmamıza gerek olmadığını öğrendim ancak aldığım hataları çözmeye çalışırken "her yol mübahtır" mottosu ile bunu kullandım. Sanıyorum bu durum primary keyler için geçerli değil. Data classımız içerisindeki değişkenin adı farklı olması ve @SerializedName kullanmak gerekiyor. Aldığım hatayı bu şekilde çözmüştüm. Sürekli hatalar ile boğuştum, hatırladıklarım bunlar :) Eklemek, yapmak istediğim çok şey vardı ancak Paging yapamayınca bütün motivasyonumu kaybettim.

<p align="center">
<img src="https://media.giphy.com/media/s98DvQYgtefdK12Km2/giphy.gif" width ="300" height="300"/>
</p>


