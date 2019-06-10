# Project 3 City Comptroller

## Main Project Responsibilites

GitMaster:
Andres

TeamLead:
Andres
Mule:
- Shaun
- Rob
- Randy

TeamLead:
Brandon
DevOps:
- Hayden
- Michelle

TeamLead:
Josh
SalesForce/Soap:
- Steve
- Dylan
- John
- Raj

TeamLead:
Eric
MicroServices:
- Mohamad
- Ross
- Devkala
- David


# SalesForce/Soap Requirements
- authentication SOAP
- expenses SOAP
- revenues SOAP

# DevOps Requirements
- Continuous Integration
  - Jenkins
    - User access configuration
    - Github web hooks
    - Pipeline configuration/architecture
    - Maven configuration (pom.xml)

- Testing 
  - Jenkins Plugin Configurations
    - JUnit (Spring-Boot apps)
    - MUnit (Mule flows)
    - Selenuim/Postman (API endpoints) 

- Continuous Delivery
  - Server Instances (AWS)
    - WebApps
    - Database(s)
    - Environment Security
      - Firewall configuration
      - SSH key/Credential management
      - Data backups
  - Configuration management
  - Maven deployment configurations (pom.xml)

- Documentation
  - RAML specifications for all endpoints
  - Wiki
  - Project name/description for portfolios & wiki
  - Internal Java code documentation (JavaDoc)
  
# MicroServices Requirements
- finance mircoservices
- micro service architecture
- apis for cities
- apis for communication for endpoints


# Project Sprints

## Sprint 1
6/4/2019

- Individual Team meetings
- each developer is given their individuals tasks by their team leads
- going over git
- talk about git standards to commit
- talk about standards and expectations
- talk about documentation

## Sprint 2
6/5/2019

- everyone commits a minimal commit
- have CI should be 100% done
- team leads need to understand messages they are getting from other API's

## Sprint 3
6/6/2019

- have all requirements ready for major code sprint for each team


## Sprint 4
6/7/2019

- team lead meeting to make sure the projects are progressing well
- if needed adjusting resources


## Sprint 5
6/09/2019

- all API’s have 80% of the code ready
- at least 50% code tested and 80% of mule code tested
- CD should be done

## Sprint 6
6/10/2019

- team meeting on the 10th
- make sure all endpoints are working
- all projects should be setup on the cloud


## Sprint 7
6/11/2019

- Code review, only cleaning up code commits such as deleting sysout lines adding comments etc. All functionality code is 100% done at this point.
- have all documentation done
- raml documentation

## Sprint 8
6/12/2019

- work on presentation
- delegate the parts of the presentation
- work on slides
- practice the presentation several times

------------------------------------------------------------------------------------------------------------------

# Project Coding Expectations/Standards

## These are important so that we are all on the same page and we will be able to provide a workable end result.

- all code should be done by 6/10/2019 no exceptions. The project should have all functionality done and should be a full working and done project

- prevent from steping on each others code

- focus on your own project

- focus on getting the project done rather than adding features that are pluses for the project

- commiting source code to git should be done daily

- any features recommended by an individual should go to the proper team lead then will be part of team leads meetings to see if its a easy addition
if its somethihng the team lead sees that its a easy addition that wont interfere with the other API's then the team lead could make the decision to add it

- primary focus is to show the clients what technologies we use rather than functionality

------------------------------------------------------------------------------------------------------------------
# Git Individual Branch Standard 
When creating your new branch follow this naming convention
```
{yourfirstname}/{teambranch}/{feature that your working on}

ex. andres/mule/addingassets
```


# Git Command Line Instructions
View the current status of your git repository and see what current branch your on.
```
git status
```
View all branches
```
git branch -a
```

starting off, copy the complete project
```
git clone
```
Before commiting you will need pull the more recent changes type
```
git pull
```

First use this command to create a new branch to the features your going to push to
```
git checkout -b newbranch
```

Then use this command for every file you changed
```
git add 'file that was changed'
```

Then commit your changes and write a message that explains what you are commiting
```
git commit -m “message”
```

The last thing is to your changes to the branch repository, merging to master will be taken care of by the git master or Jenkins
```
git push origin <nameofbranch>
```

# Git Eclipse Instructions
Before commiting you will need pull the more recent changes type
-On the git Repositories tab right click your project name and select pull

First follow these steps to create a new branch to the features your going to push to
- Click Git icon on the upper right then under the git repositories tab right click the project name and select switch to New Branch
- Under unstaged changes tab drag and drop the files from unstaged to staged put the files you have made changes to. 
- If you don't see any files that you changed on the unstaged files then on the upper right on top of the commit tab click the refresh button and this
will refresh the view.
- Write a message under the commit tab of the changes you made and then click the Commit and Push button.


