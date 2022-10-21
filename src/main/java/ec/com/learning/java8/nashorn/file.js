var names = ['Steven', 'Andres', 'German', 'Gregorio'];
print(names);

function calculate(number1, number2) {
    return number1 + number2;
}

var threadImpl = {
    run: function () {
        for (var i = 0; i < 20; i++) {
            print("printing " + i);
        }
    }
};
