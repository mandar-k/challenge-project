# Challenge - Help Robotics Inc. with a new web-service with  REST API

Robotics Inc. builds and manages an inventory of smart robots that aid in disaster
management, from fires to earthquakes. As the business has grown, Robotics Inc.
needs a new software to scale their business. Here are the requirements:
1. The software should be available as a web-service with a REST API and Web
Dashboard
2. The software should allow Robotics Inc. to track the following 3 states in a robot’s
lifecycle - robots that are currertly being designed, robots have been tested and ready to
ship, or robots deployed on field
3. The software should allow Robotics Inc. to add new new robots, or update entries of
existing robots, or mark robots as damaged beyond repair (end-of-life) using its unique
id
4. The software should allow Robotic Inc. to query the robot inventory for a list and
count of robots that are in each of the three lifecycle states
5. Each robot has a unique id and other attributes such as name, year built, mass,
color, and a list of functions (e.g. light sensing, sound sensing, temperature sensing,
pressure sensing, mobility degrees-of-freedom)
You have been hired as a new software architect by Robotics Inc. While they think that
this software is a multi-year costly development effort, you want to prove them that this
is simple to build. You plan to build a prototype a web-service in 2-3 days with the
following details.
 - Use any database of choice for the storing the robot inventory
 - Use any web application framework (Play, Spring, etc.) to build a web-service
 - Provide GET, POST, PUT, and DELETE endpoints for the robot inventory. The DELETE endpoint marks the robot as damaged beyond repair so that it does not show up when the inventory is queried.
 - You get extra points if you can also show the results of the following queries on a
   web-page, calling the web-service REST API you provide.
   GET call to get all robots
   GET call to get robots in each of the three lifecycle states
   To resolve GET all records execute this query in couch database CREATE PRIMARY INDEX `robotics-inc-primary-index` ON `robotics-inc` USING GSI;
