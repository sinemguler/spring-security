# spring-security

***Spring Security & JWT***

**JSON Web Token(JWT) Yapısı**

*JWT ile üretilen token Base64 ile kodlanmış 3 ana kısımdan oluşmaktadır. Bunlar Header(Başlık), Payload(Veri), Signature(İmza) kısımlarıdır.*

**Header (Başlık)**
*JWT’de kullanılacak bu kısım JSON formatında yazılmaktadır ve 2 alandan oluşmaktadır. Bunlar token tipi ve imzalama için kullanılacak algoritmanın adıdır.*

`{
  "alg": "HS256",
  "typ": "JWT"
}`

*Algoritma kısmında HS256, HMAC SHA256 ya da RSA gibi birçok farklı algoritma kullanılabilir. Type kısmında ise JWT yazmaktadır. Bu kısım Base64 ile encode edilir ve oluşturulacak tokenın ilk parçasını oluşturur.*

**Payload (Veri)** 
*Bu kısım ‘**claim**’leri içerir. Bu kısımda tutulan veriler ile token istemci ve sunucu arasında eşsiz olur. Bu kısımda 3 tip claim bulunmaktadır.*

- **Registered (Kayıtlı) Claims**:
*JWT tarafından önceden reserve edilmiş 3 harf uzunluğunda claimlerdir. Kullanılması zorunlu değildir fakat önerilir*

    **iss** *(issuer)*, **exp** *(expiration time)*, **sub** *(subject)*, **aud** *(audience)*
    
- **Public (Açık) Claims**: *İsteğe bağlı, açık yayınlanan claimlerdir.*

- **Private (Gizli) Claims**: *Tarafların kendi aralarında bilgi taşımak için kullandığı gizli claimlerdir.*   

`{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}`

**Signature (İmza)**
*JWT’nin onaylanmasından imza sorumludur. Signature kısmınının oluşması için, base64 ile encodlanmış header, base64 ile encodlanmış payload ve belirlenen bir secret key gereklidir. Sonrasında imza oluşturmak için header’da tanımlanan hashleme algoritması kullanılır.*

`HMACSHA256(base64UrlEncode(header) + “.” + base64UrlEncode(payload), secret)`
