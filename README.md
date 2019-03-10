Assignment

Create a search application where you expose an endpoint for a client to search based on a certain radius for tree related data.

- You can find Street tree data from the TreesCount 2015 here => https://data.cityofnewyork.us/Environment/2015-Street-Tree-Census-Tree-Data/uvpi-gqnh
- The direct call to api is `https://data.cityofnewyork.us/resource/nwxe-4ae8.json`
- You have to expose and API endpoint accepting two parameters 
    1. A Cartesian Point specifying a center point along the x & y plane
    2. A search radius in meters

Output
 - You have to retrieve the count of "common name" (please see in the documentation on the same page above which field to refer to) for all 
 the species of trees in that search radius
 - Expected outcome from the api
```json
{
    "red maple": 30,
    "American linden": 1,
    "London planetree": 3
}
```

Example: http://localhost:8080/tree/treedata?radius=30&point=%7B%22x%22%3A1027431.148%2C+++%22y%22%3A202756.7687%7D

Above link will return the below.
```json
{
    "cherry": 2,
    "honeylocust": 1,
    "eastern redbud": 2,
    "red maple": 1
}
```