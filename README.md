# Prime Finder

Fun project to test out different methods for finding prime numbers

## Implemented methods

### Simple Primality

Follows some of the ideas listed in https://en.wikipedia.org/wiki/Primality_test#Simple_methods 
but simplifies the last step a bit.

### Fermat Primality

Follows https://en.wikipedia.org/wiki/Fermat_primality_test which is a probabilistic test based off of 
Fermat's little theorem.

### AKS Primality

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

### Simple Primality

![Simple Graph][image_simple_graph]

### Fermat Primality

![Fermat Graph][image_fermat_graph]

## TODO

* Add implementation for AKS Primality
* Add notes about what limit each of these primality methods start
 inevitably failing due to accuracy errors, memory limits, etc.

[image_simple_graph]: ./images/simple_graph.png "Simple Graph"
[image_fermat_graph]: ./images/fermat_graph.png "Fermat Graph"
