# Installation
* Install Weblogic  12.2.1.0.0
* Install Oracle Database as docker container using this command:
  `docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle123 gvenzl/oracle-xe:latest`
* Add oracle data-source in weblogic dashboard
* Deploy using maven: mvn clean install
# Test
**GET** **Search Reports**

URL: `localhost:7001/api/report/v1/search?filter= [{"property":"id","operator":"eq","value":"3"},{"property":"code","operator":"eq","value":"022215"},{"property":"amount","operator":"eq","value":"646566556"}]&start=0&limit=10`

**Request description**
* filter: `[{"property":"id","operator":"eq","value":"3"},{"property":"code","operator":"eq","value":"022215"},{"property":"amount","operator":"eq","value":"646566556"}]`
* start: 0
* limit: 10
---------------------------------
**POST** **Create Report**

URL: `localhost:7001/api/report/v1/create`

Body:
`{
"id": null,
"code": "022215",
"amount": 646566556
}`