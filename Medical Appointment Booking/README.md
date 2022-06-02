# Medical Appointment Booking

Medical appointment booking is an application for booking appointments for doctors for various specialisations. A patient can use the application to search doctors by specialisations or by city. Once the patient has finalized the doctor, the patient should be able to book an appointment with the doctor for a specific slot.

 

Following entities will be present in the applications:

* Doctor
* Appointment
* Patient

 
A doctor should be able to register in the application with the following details of theirs:

* First Name
* Last Name
* Specialization
* Registration Number
* Years of Experience
* Qualification
* Clinic Name

 
The list of specializations should be already defined at the system level, and the doctors should be able to choose from the list. The doctors should also be able to add multiple booking slots, each containing the following details:

* Start Hour
* End Hour
* Day of week
* Clinic ID

 
The start and end hours will follow the 24-hour format. The doctors can add their available hours like this: 10(Start Hour - the equivalent of 10 am) to 13(End Hour - the equivalent of 1 pm) for Monday and then again another booking slot for the same day from 14(Start Hour) to 18(End Hour). The day of the week will to be chosen from a fixed set of values, defined in the system to ensure consistency. 

 
While the doctors can add their available hours in a range spanning up to 12 hours, the users will be able to book a slot of the duration of 1 hour only. The application will keep track of the availability of the doctor for every 30 minute time interval, starting at each hour of the doctor's available time. i.e. if the doctor has added that, he/she will be available from 10 am to 12 pm in a day, then the users can book an appointment in either of these slots: 10:00 am to 11:00 am, 11:00 am to 12:00 pm. Once a user has booked the slot 10:00 am to 11:00 am on a specific date, the doctor will not be available for another booking in the same time range.

 
A user should be able to register with the following profile details:

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

 
Once the user completes registration, the system will capture the time(Format: dd/MM/yyyy hh:mm:ss AM/PM), when the user has registered.

 
A user will be able to search for a doctor by his/her specialisation, city. The user chooses a doctor, the user will be able to see the list of available time slots(each spanning 30 minutes) for booking. The user can select an available time slot for a specific doctor and book an appointment. 



An appointment will capture the following details and will print the details, when required.

* User name
* Doctor name
* Date
* Start Hour
* Clinic Name
* City

 
User, Doctor & Appointment- each of these entities will also have 2 more attributes:

Instance level "ID"

A static variable named "counter", which will be initialized with 1. In each object creation, the "ID" attribute will be set as the current value of this variable. And after the object creation, this static variable needs to be incremented by 1. 

 