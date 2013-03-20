## Todo List
* Settings (Done)
* Flexible Bonus System (Done)
* Abstract Base Classes (Done)
* Health Calculations (Done)
* Defense Calculations
* Skills (with User Select Support)
* Weapons (with User Select Support)
* Armor (with User Select Support)
* Feats (with User Select Support)
* Data Definition Files (Using XPath)
* Point-Buy Attribute Generator
* User-Specified Attribute Preferences (instead of Class-Specified Attribute Preferences)

### User Specified Attribute Preferences
```java
String[] array = preferences.split(",");
Vector<Integer> values = new Vector<Integer>();
for(String value : array){
    values.add(Integer.valueOf(value));
}
_class.setPreferred(values);
```
