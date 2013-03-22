## Todo List
* ~~Settings (Done)~~
* ~~Flexible Bonus System (Done)~~
* ~~Abstract Base Classes (Done)~~
* ~~Health Calculations (Done)~~
* ~~Defense Calculations (Done)~~
* ~User-Specified Preferences (Done)~~
* Data Definition Files (Using XPath)
* Skills
* Weapons
* Armor
* Feats
* Point-Buy Attribute Generator
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