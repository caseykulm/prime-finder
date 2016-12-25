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

### SimplePrimality

primes <= 1,000  
millis to find:		4.0  
seconds to find:	0.004  
minutes to find:	6.666667E-5  

primes <= 10,000  
millis to find:		16.0  
seconds to find:	0.016  
minutes to find:	2.6666667E-4

primes <= 100,000  
millis to find:		51.0  
seconds to find:	0.051  
minutes to find:	8.5E-4  

primes <= 1,000,000  
millis to find:		445.0  
seconds to find:	0.445  
minutes to find:	0.0074166665  

primes <= 10,000,000  
millis to find:		8530.0  
seconds to find:	8.53  
minutes to find:	0.14216666  

primes <= 100,000,000  
millis to find:		204895.0  
seconds to find:	204.895  
minutes to find:	3.4149168  

### AksPrimality

primes <= 1,000

primes <= 1,000,000

primes <= 100,000,000


## TODO

* Add unit tests to validate against http://primes.utm.edu/lists/small/millions/
* Add log-graphs for time tests
* Add implementation for AksPrimality as well as run times
* Add notes about what limit each of these primality methods start
 inevitably failing due to accuracy errors, memory limits, etc.
