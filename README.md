# NotesProject
for oneTeamAnywhere coding test

After downloading the project, do the ff:
1.)make sure to reload all maven dependencies
2.) run maven clean and rebuild
3.) On configuration settings, make sure that the working directory is pointing to where you downloaded this project

After doing this, you should be able to run it

Below are the apiEndpoints to use
POST http://localhost:8080/notes --this creates note
GET http://localhost:8080/notes  --get all notes
GET http://localhost:8080/notes/{id} --get one note 
PUT http://localhost:8080/notes/{id} --update one note
DEL http://localhost:8080/notes/{id}  --delete one note 

