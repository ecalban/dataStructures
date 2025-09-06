It is an Animal Shelter Management System project where we can perform operations such as adding, extracting, updating, query and displaying on data.

The data was kept in a text file without any database. Instead of a ready-made data structure, a Linked List data structure created from scratch was used.

Data insertion process: The data we receive from the user is first added to the Linked List data structure, then the data structure is read and added to the text file. During this time, the received data is subjected to the validation process.

![Image](https://github.com/user-attachments/assets/7802f742-d96d-443d-8b6f-29f5221faec3)

![Image](https://github.com/user-attachments/assets/d1dc43c8-1775-46f5-9700-839c889119dd)

Data extraction process: The animal with the id number received from the user is extracted from the data structure, then the new data structure is read again and added to the text file.

Data update process: The data of the animal with the id number we received from the user is first updated in the Linked List data structure, then the data structure is read and added to the text file.

Data query process: The id number, which is the key we receive from the user, is queried in the Linked List data structure and if there is an animal with the id number in the data structure, this animal is displayed.

Data display process: All data belonging to animals in the text file are displayed in order of name, species, age and id.

The user interface is made with JavaFX and CSS support.

If you're wondering how it works, here's a link to the video I tested:

https://youtu.be/XlqK1VFVhPw

If you want to run this project, make sure you have done the necessary installations (JavaFX, Java). If your installation is ready, when you run the project you will see two options. One of them is administrator login, the other is user login. Here is the login information you need to know:

username: ecalban, password: eren12345 (for the administrator)

username: ECALBAN, password: EREN12345 (for the user)

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
