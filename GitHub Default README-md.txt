# Project Title: Clock

This clock project is an upgrade of a graphic project in our previous chapter that created a non-
functional clock. The requirements of this project is to upgrade that clock into a functional clock 
that can be started and stopped with buttons.

## Example Output

This image will display as your example output. Name the image README.jpg in your project folder.

![Sample Output](README.jpg)

## Analysis Steps

Considering most of the code is supplied for this project, the extent of analysis is focused on where and 
how to implement the animation and the start and stop event handling.

### Design

The design of this program is mostly supplied. There is a ClockPane class and a class to instantiate an 
object of ClockPane. The math formulas that determine the ending x/y coordinates of the clock hands was 
thankfully supplied with the original program, as it is quite complex. My design choices as to where and 
how to implement the upgrade code was based on common sense and examples of similar working code. The
animation portion was implemented in the constructors of ClockPane and simply redraws the clock every second,
advancing the hands forward by adding 1 to each ending x/y coordinate as appropriate. the event handling 
was implemented in the tester class and calls methods in ClockPane class to do the work.
I spent a good deal of time improving the clock graphics design and added a mark for each hour.

### Testing

Initial program requirements:

I used the original code and ran the program to make sure it worked.

Adding animation:

After plugging in the standard Timeline/KeyFrame code and creating a method that mathematically advances
the clock hands, I ran the program several times to work out some logic bugs in my method.

Adding events/event handling:

The buttons to stop/start the clock were simple to create and the event handlers were standard-issue
textbook examples, and they worked the first time I ran the program after coding them in.

## Notes

I had a little trouble working out the math for advancing the second hand. Adding the graphics for additional
hour marks was the most challenging part, however.

## Do not change content below this line
## Adapted from a README Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
