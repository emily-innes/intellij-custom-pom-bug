# What is this?

In another multi-module project that I maintain, some modules have multiple POM files in order to enable users to build subsets
of the project quickly and independently of eachother. The POMs declared as submodules of the root pom have custom names, while
the pom.xml files used to build the sub-projects are all named "pom.xml" and not declared as modules of any other project. These subprojects build and run tests successfully when built using Maven, but
cannot be built through IntelliJ IDEA 2020.3.3

This project is an attempt to replicate the issue.

There are 4 sub-modules of the main build:

1. "StandardModule" and "AnotherModule" follow the normal module conventions: just 1 POM file named "pom.xml".
2. "CustomChildModuleOnePom" is a regular module in which the POM file has a custom name.
3. "CustomChildModule" is a child module that also has a POM file with a custom name. The directory also contains an unrelated "pom.xml" aggregator-pom that can be built and executed separately from the main build.

ResourceTest and AnotherResourceTest were added to further illustrate the issue.
Both of these tests pass when invoked through Maven + surefire, but only the test in the module with the singular pom file can run through IntelliJ, as the "Build" action does not successfully copy resources.

The expected project structure, as demonstrated by CustomChildModuleOnePom
![Expected Project Structure](Expected%20Project%20Structure.png)

The actual project structure, as demonstrated by CustomChildModule
![Actual Project Structure](Actual%20Project%20Structure.png)

The simple workaround for this issue would be to manually override the project structure. This solution does not work in the long term, as any re-importing or reloading of the project seems to reset the project structure
back to the unbuildable version.