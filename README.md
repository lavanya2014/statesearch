# statesearch
coding test solution for states search rest service.

Implemented all of below:
1.	Consume the above api using Java, Spring, Jersey 2.0 and any other open source tool you want.
2.	Expose a restful endpoint where user can search by any states and get the information about that states back in the response.
•	For example, if I pass Alabama it should return me Alabama information only or if I pass multiple states it should filter based on that.
•	Design your endpoint naming convention and utilize appropriate Rest Method to return the response back.
3.	Add any exception catching, proper naming convention, junit tests, input validation.
4.	Create war file so it can be deployed in Tomcat 8.
5.	It must be a maven project so we can build the project and generate war file.
6.	Send the code, war file and the endpoint uri. 
7.	Bonus: If you can publish in Github so we can download it.
8.	Bonus: If no states are passed it should return all the states.
9.	Bonus: Code coverage report using Jacaco/Cobertura.

Download maven project and install and run.

Accessed and tested with urls: 
http://localhost:8087/StateSearch/rest/states/get/Alabama

<img width="1280" alt="test 4" src="https://user-images.githubusercontent.com/6617982/44186925-3eba7a80-a0ea-11e8-930e-5bfe2a0be798.png">


http://localhost:8087/StateSearch/rest/states/get/AL

<img width="1278" alt="test 2" src="https://user-images.githubusercontent.com/6617982/44188087-dd46db80-a0ea-11e8-8f35-dcc282b8d259.png">


http://localhost:8087/StateSearch/rest/states/get/AL,Georgia,NH

<img width="1253" alt="test 3" src="https://user-images.githubusercontent.com/6617982/44186964-5560d180-a0ea-11e8-869f-d891091b15e9.png">


http://localhost:8087/StateSearch/rest/states/get/

<img width="1269" alt="test 4" src="https://user-images.githubusercontent.com/6617982/44186935-4f6af080-a0ea-11e8-83a7-d416a55e3bb1.png">




