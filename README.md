# Super-Caller-Id
A super powerfull SDK to get info about any mobile/phone number around the world.

## Dependency
1. Include "supercaller.aar" in libs folder of your project.
2. Add dependency:
   ```
   implementation(files("libs/supercaller.aar"))
   ```
## Usage
There are 3 types of information based on different APIs which are reverse engineered. USMLE us number is used to test:

### Type 1 
#### Request:
```
val type1 = Supercaller.getPhoneDetailsType1(
        "2155909700",
        "US"
    )
```
1. Param 1 is full mobile/phone without country code
2. Second param is Country code e.g. PK, US
#### Successfull response:
```
Type1: {"error":0,"data":{"name":"Natl Board Med","countryCode":"US","nationalFormat":"(215) 590-9700","dialingCode":1}}
```

### Type 2
#### Request:
```
val type2 = Supercaller.getPhoneDetailsType2("12155909700")
```
1. Param is full international number without + or double zero
#### Successfull response:
```
Type2: {"name":"nbme","websites":[{"websiteUrl":"http://www.usmle.org/"}],"addresses":[{"type":1,"street":"3750 Market St, Philadelphia, PA 19104, USA"},{"type":1,"street":"3750 Market St, Philadelphia, PA, 19104-3102"}],"reviews":[{"excerpt":"Test center for Step 2 CS","url":"https://maps.google.com/?cid=6918934848447144906","type":1}],"avgRating":5.0,"openingHours":{"monday":["08:00 - 17:00"],"tuesday":["08:00 - 17:00"],"wednesday":["08:00 - 17:00"],"thursday":["08:00 - 17:00"],"friday":["08:00 - 17:00"]},"lat":39.9562451,"lng":-75.197445,"url":"http://www.usmle.org","googlePlacesId":"ChIJSzX74lbGxokRjBhqevGixUg","priority":11}
```

### Type 3
#### Request:
```
val type3 = Supercaller.getPhoneDetailsType3("12155909700")
```
1. Param is full international number without + or double zero

#### Successfull response:
```
Type3: [{"name":"NBME","type":""}]
```

### Important:
This SDK is based on other APIs(Reverse Engineered). These APIs are using token based system and may expire any time.
So I will try my best to update the SDK as soon as possible.
Now what you have to do is to develop an app in just a week, upload to google play store and spend super powerfull investment in
google ads. Next in your app, save all these fetched information which you will show to the user on your own server as well. 
This will populate your own database and you can use it independently.

### Note:
If any of these 3 types of request fails to work then do not panic. Just create an issue and i will try my best to fix it.
