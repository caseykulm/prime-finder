# Prime Finder

Fun project to test out different methods for finding prime numbers

## Implemented methods

### SimplePrimality

Follows some of the ideas listed in https://en.wikipedia.org/wiki/Primality_test#Simple_methods 
but simplifies the last step a bit.

### AksPrimality

Follows https://en.wikipedia.org/wiki/AKS_primality_test which is much more efficient, and
was very important theoretically, but is not the go to fast primality test used these days.

## Time Tests

Hardware specs  
OS: 64bit Mac OS X 10.11.6 15G31  
Kernel: x86_64 Darwin 15.6.0  
CPU: Intel Core i7-4870HQ CPU @ 2.50GHz  
GPU: AMD Radeon R9 M370X / Intel Iris Pro  
RAM: 16384MiB 

Link to Google Drive Sheets document tracking below stats, 
https://docs.google.com/spreadsheets/d/1POv59qWYwPUbKQqnyV46yelLRFuxcJjXjw7V35h-wuA/edit?usp=sharing

### SimplePrimality

![Simple Graph][image_simple_graph]

### AksPrimality


## TODO

* Add unit tests to validate against http://primes.utm.edu/lists/small/millions/
* Add log-graphs for time tests
* Add implementation for AksPrimality as well as run times
* Add notes about what limit each of these primality methods start
 inevitably failing due to accuracy errors, memory limits, etc.

[image_simple_graph]: ./images/simple_graph.png "Simple Graph"