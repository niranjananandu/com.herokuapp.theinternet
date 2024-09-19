# The Internet Heroku app

This README provides an overview of the Internet Heroku app web application automation project and its setup

## Table of Contents

- [Description](#description)
- [Framework](#framework)
- [Installation](#installation)
- [Contact](#contact)

## Description

The aim of the project is to create an automation framework to automate several workflows within the Internet Herokuapp application. The project is built using Selenium and Java as the programming language.

## Framework
The project is built using Selenium with Java , using TestNG framework and Maven build tool.
Page Object Model is utilised to build the tests. Elements from different pages of the application are grouped into its respective pages - Login,Drag And Drop etc.
The base urlis saved on a config.properties file. 
A Log4j2 logger is implemented which defines the logging format and logging level and is configured to log to console. 
Extent report is implemented to generate a report after running the tests, which also adds screeshots at failed steps.
 
## Installation

To install and run this project, follow these steps:

1. On GitHub.com, navigate to https://github.com/niranjananandu/com.herokuapp.theinternet
2. Above the list of files, click Code.
3. Click Download ZIP.
4. Extract the files and run the run.bat file in the folder (Edit the directory to your local directory. Install any dependencies).

## Contact
Name: Niranjana Nandu
email: nanduniranjana@gmail.com


