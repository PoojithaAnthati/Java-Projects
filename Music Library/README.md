Music Library application keeps track of songs being played by various users in the system. There are three major entities in the system:

1. Songs
2. Users
3. Artists
 

Each of these entities will have 2 more attributes:

* Instance level attribute "ID"

* A static variable named "counter", which will be initialized with 0. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1. 

 

The system will have the provision of registering users with the following attributes:

* First name
* Last name
* Contact
* Email ID
* Phone
* Address
* City
* Locality
* State
* Pin Code 

 

Add artists with the following attributes:

* First name
* Last name
* List of Songs released

 

Capture the following details for songs:

* Title
* Genre
* Release year
* Language
* total Listens

 

The songs also record which artist by artist ID.


The class with the name MusicLibrary, will keep track of the list of all users, songs, and artists. It also store the user's history of playing songs. This will support the following operations:

* Register a user
* Register an artist
* Release a song
* Mark a user playing a song
* Get top 10 songs for a specific user
* Get top 10 songs overall
* Get the list of songs of a specific artist

