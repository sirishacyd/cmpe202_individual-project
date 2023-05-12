# Individual-project
Course Name :Software Systems Engineering</br> 
Project Name:Credit card problem</br>
Student Name:[Sirisha Polisetty](https://www.linkedin.com/in/sirishapolisetty/)<br/>
University Name:[San Jose State University](https://www.sjsu.edu/)<br/>
Professor's Name:[gopinath V](https://www.linkedin.com/in/gopinath-v-75286719/)</br> 

## Java Version

Ensure you have Java version 1.8.0_333 installed and configured; you can check this by running java -version in your terminal before proceeding with the project setup.

```
siris-MacBook-Pro:indivi-202 siri$ java -version
java version "1.8.0_333"
Java(TM) SE Runtime Environment (build 1.8.0_333-b02)
Java HotSpot(TM) 64-Bit Server VM (build 25.333-b02, mixed mode)
```

## To build the project, execute the command mvn clean install in your terminal, which will clean the target directory, compile the source code, and generate the output artifacts

```
siris-MacBook-Pro:indivi-202 siri$ mvn clean install
```

![build](screenshots/buildlogfile.txt)

For usage, run the command java -jar target/individual-project-siri.jar [input_file_path] [output_file_path] with the desired CSV input file and the intended output file path

## CSV
```
siris-MacBook-Pro:indivi-202 siri$ java -jar target/individual-project-siri.jar src/main/resources/input_file-1.csv src/main/resources/output_file-1.csv
Output successfully written to src/main/resources/output_file-1.csv
```
```
siris-MacBook-Pro:indivi-202 siri$ cat src/main/resources/output_file-1.csv 
cardNumber,cardType
5567894523129089,MasterCard
59012345678901234567890,Invalid: more than 19 digits
4123456789123,Visa
347856341908126,AmericanExpress
6011111100007756,Discover
3601112345678789,Invalid: not a possible card number
5167894523129089,MasterCard
4123456789123999,Visa
377856341908126,AmericanExpress
5367894523129089,MasterCard
6011*890HJrt6789,Invalid: non numeric characters
,Invalid: empty/null card number
```
For usage, run the command java -jar target/individual-project-siri.jar [input_file_path] [output_file_path] with the desired json input file and the intended output file path
```
siris-MacBook-Pro:indivi-202 siri$ java -jar target/individual-project-siri.jar src/main/resources/input_file-1.json src/main/resources/output_file-1.json
Output successfully written to src/main/resources/output_file-1.json
```

```
siris-MacBook-Pro:indivi-202 siri$ cat src/main/resources/output_file-1.json
{
  "cards" : [ {
    "cardNumber" : "5567894523129089",
    "CardType" : "MasterCard"
  }, {
    "cardNumber" : "59012345678901234567890",
    "CardType" : "Invalid: more than 19 digits"
  }, {
    "cardNumber" : "4123456789123",
    "CardType" : "Visa"
  }, {
    "cardNumber" : "347856341908126",
    "CardType" : "AmericanExpress"
  }, {
    "cardNumber" : "6011111100007756",
    "CardType" : "Discover"
  }, {
    "cardNumber" : "3601112345678789",
    "CardType" : "Invalid: not a possible card number"
  }, {
    "cardNumber" : "5167894523129089",
    "CardType" : "MasterCard"
  }, {
    "cardNumber" : "4123456789123999",
    "CardType" : "Visa"
  }, {
    "cardNumber" : "377856341908126",
    "CardType" : "AmericanExpress"
  }, {
    "cardNumber" : "5367894523129089",
    "CardType" : "MasterCard"
  }, {
    "cardNumber" : "6011*890HJrt6789",
    "CardType" : "Invalid: non numeric characters"
  }, {
    "cardNumber" : null,
    "CardType" : "Invalid: empty/null card number"
  } ]
}
```
For usage, run the command java -jar target/individual-project-siri.jar [input_file_path] [output_file_path] with the desired xml input file and the intended output file path
```
siris-MacBook-Pro:indivi-202 siri$ java -jar target/individual-project-siri.jar src/main/resources/input_file.xml src/main/resources/output_file-1.xml
Output successfully written to src/main/resources/output_file-1.xml
```
```
siris-MacBook-Pro:indivi-202 siri$ cat src/main/resources/output_file-1.xml
<CARDS>
  <CARD>
    <CARD_NUMBER>5567894523129089</CARD_NUMBER>
    <CARD_TYPE>MasterCard</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>59012345678901234567890</CARD_NUMBER>
    <CARD_TYPE>Invalid: more than 19 digits</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>4123456789123</CARD_NUMBER>
    <CARD_TYPE>Visa</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>347856341908126</CARD_NUMBER>
    <CARD_TYPE>AmericanExpress</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>6011111100007756</CARD_NUMBER>
    <CARD_TYPE>Discover</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>3601112345678789</CARD_NUMBER>
    <CARD_TYPE>Invalid: not a possible card number</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>5167894523129089</CARD_NUMBER>
    <CARD_TYPE>MasterCard</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>4123456789123999</CARD_NUMBER>
    <CARD_TYPE>Visa</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>377856341908126</CARD_NUMBER>
    <CARD_TYPE>AmericanExpress</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>5367894523129089</CARD_NUMBER>
    <CARD_TYPE>MasterCard</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER>6011*890HJrt6789</CARD_NUMBER>
    <CARD_TYPE>Invalid: non numeric characters</CARD_TYPE>
  </CARD>
  <CARD>
    <CARD_NUMBER></CARD_NUMBER>
    <CARD_TYPE>Invalid: empty/null card number</CARD_TYPE>
  </CARD>
</CARDS>
```
## Validations
Ensure that the required number of arguments are passed during execution, as the program performs validations to check for the correct input and output file paths
```
siris-MacBook-Pro:indivi-202 siri$ java -jar target/individual-project-siri.jar 
Invalid syntax. Usage: java Main <input filename> <output filename>
```
