## Todo List
* ~~Settings (Done)~~
* ~~Flexible Bonus System (Done)~~
* ~~Abstract Base Classes (Done)~~
* ~~Health Calculations (Done)~~
* ~~Defense Calculations (Done)~~
* Skills
* Weapons
* Armor
* Feats
* Data Definition Files (Using XPath)
* Point-Buy Attribute Generator
* User-Specified Preferences (instead of Class-Specified or Race-Specified Preferences)
* Paragon Paths and Epic Destinies
* Skill Powers
* Class Powers
* Racial Powers

### User Specified Attribute Preferences
```java
String[] array = preferences.split(",");
Vector<Integer> values = new Vector<Integer>();
for(String value : array){
    values.add(Integer.valueOf(value));
}
_class.setPreferred(values);
```