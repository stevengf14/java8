var javaClass = Java.type(java.util.ArrayList);
var list = new javaClass;
list.add('Steven');
list.add('Andres');
list.add('German');
list.add('Gregorio');

print(list.get(3));