# Readme

# Sprint 1		June 5
	Stand up basic Microservice Architecture
	Get each member started on a REST API

# Sprint 2		June 6
	Get at least one functioning REST API from each person
	Make sure every team members has APIs to work on

# Sprint 3		June 8
	Finish all REST APIs and check to ensure that no more functionality is needed
	Look at developing the Architecture and adding additional Microservice tools/functionality (such as ribbon)
	Check for bugs
	Ensure Documentation is available where needed

# Sprint 4		June 10
	Work with other teams to ensure full integration
	Get rid of all bugs and upgrade Architecture as much as possible

# Sprint 5		June 12
	Work on Presentation

```
#%RAML 1.0

title: Quoting API

baseUri: TBA

version: v1

/building:

  /{squarefeet}:
  
      get:
      
        description: describes the price of building breaks it down by materials and labor
        responses:
        
          200:
          
            body:
            
              application/json:
              
                example: |
                  [{
                      "StudFrame-total": "price for square foot",
                      
                      "StudFrame-matrials": "price for square foot",
                      
                      "StudFrame-labor": "price for square foot",
                      
                      "tilt-total": "price for square foot",
                      
                      "tilt-matrials": "price for square foot",
                      
                      "tilt-labor": "price for square foot",
                      
                      "SteelFrames-total": "price for square foot",
                      
                      "SteelFrames-labor": "price for square foot",
                      
                      "SteelFrames-matrials": "price for square foot",
                      
                      "foundataion": "price for square foot",
                      
                      "contruction": "price for square foot",
                    }]
/Equipment:

  /{department}:
  
    /{name}:
    
      /{quanity}:
      
        get:
        
          description:
          
          responses:
          
            200:
            
              body:
              
                application/json:
                
                  example: |
                    {
                      "equipment":"total price"
                      }
```
