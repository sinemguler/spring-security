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


---------------------------------------------------------------------------------------------------------------------------------------------------------------------
**JSON Web Token(JWT) Structure**
The token produced with JWT consists of 3 main parts encoded with Base64. These are Header, Payload (Data), Signature (Signature) parts.

**Header**
*This part to be used in JWT is written in JSON format and consists of 2 fields. These are the token type and the name of the algorithm to be used for signing.*

`{
  "alg": "HS256",
  "typ": "JWT"
}`

*Many different algorithms such as HS256, HMAC SHA256 or RSA can be used in the algorithm part. In the Type section, it says JWT. This part is encoded with Base64 and forms the first part of the token to be created.*

**Payload** 

*This section includes '**claims**'. With the data held in this section, the token becomes unique between the client and the server. There are 3 types of claims in this section.*

- **Registered Claims**:
*Claims with a length of 3 letters pre-reserved by JWT. Not required but recommended*

**iss** *(issuer)*, **exp** *(expiration time)*, **sub** *(subject)*, **aud** *(audience)*

- **Public Claims**: *Optional, publicly published claims.*

- **Private Claims**: *They are confidential claims used by the parties to convey information among themselves.*   

`{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}`

**Signature**
*The signature is responsible for the approval of the JWT. In order for the signature part to be formed, a base64 encoded header, base64 encoded payload and a specified secret key are required. Then, the hashing algorithm defined in the header is used to create the signature.*

`HMACSHA256(base64UrlEncode(header) + “.” + base64UrlEncode(payload), secret)`
