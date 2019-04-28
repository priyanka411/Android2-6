# Android2-6

## Project Title

What's Good Here

- It's a food rating app.

## Icon for our app:

![logo](https://github.com/priyanka411/Android2-6/blob/master/logo.png)

### project repo- https://github.com/priyanka411/Android2-6/tree/master/project2-6 
## Group Members
* Priyanka Bonam
* Zaiba Ali
* Meghana Putta
* Himabindu Poshala

## Activities
### Priyanka Bonam
     * Database handler- created a database to store the user login details, predefined vendor login details, and user comments, and food center details.
     * Also, design interface to let user give comments along with rating
     * For security purpose designed the app in a way that Vendors login details should match with the food center selection in dropdownlist in firstactivity(Example if you select mooyah in dropdownlist, and want to login as a vendor you can only login with mooyah credentials)
     * Added logout functionality
     Database used-SQLite
     * Rating- used MaterialRatingBar API which I found in github(https://github.com/DreaminginCodeZH/MaterialRatingBar)
     * Java files I worked:
               * Database handler
               * Leave a comment
               * Layouts- Activity login, Activity-register, item_ratting

### Zaiba Ali
     * vendor needs to login with vendor login id and passwaord and they will be able to see all the   comments and rating given by customers. Also, they can see graph which will be created     according to user ratings. 
     * Rating Adapters
     * UI- Graph view, Splash
     * Layouts- Activity graph view, Activity splash

     * Api fo graph- https://github.com/lecho/hellocharts-android

### Meghana Putta
     * comment - Users can comment about their experiences in the food centers i.e., write remarks expressing like or dislike.
     * UI- MAinactivity, SelectedfoddCenter, Thanku(java files)
     * Layouts- Activity main, thanku, Activity SelectedfoddCenter(xml files)

### Himabindu Poshala
     * MyApplication - Comments are added by logging into user account with email ID and password.For password it will ask to confirm the password twice.We can add comments to respective stations with the login details.
     *JAVA Files are Register, SelectedfoddCentervendor
     *xml files are Register, Activity SelectedfoddCentervendor

### DataBase
SQlite
MaterialRatingBar API for star rating
hellocharts-android API for graphs


### Predefined vendor login details

Vendors login details should match with the food center selection in dropdownlist in firstactivity(Example if you select mooyah in dropdownlist, and want to login as a vendor you can only login with mooyah credentials)
### Test credentials

For Users can register and login with email address to leave a comment

-For the vendors, here're the details:

chcikfila@gmail.com
password:chickfila

mooyah@gmail.com
password:mooyah

zen@gmail.com
password:zen

einsteinbagels@gmail.com
password:einsteinbagels

### Supported devices 

Min api list 15, so app will work on 100% android devices (approximately)


