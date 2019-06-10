# Readme
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
                    
           
