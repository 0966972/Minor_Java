// opdracht 5
console.log('opdracht 5')
var number = Math.random();
var x_stmnt;
if (number > 0.7) {
    x_stmnt = 1;
} else {
    x_stmnt = 0;
}

var x_expr = number > 0.7 ? 1 : 0;

console.assert(x_stmnt === x_expr);
console.log(x_stmnt === x_expr)

// opdracht 6
console.log('opdracht 6')
var arr = Array(50).fill(null);

var i;
var arr2_stmnt = [];
for (i = 0; i < arr.length; i += 1) {
    var val = Math.random();
    if (val < 0.3) continue;
    val = Math.floor(val * 100);
    arr2_stmnt.push(val);
}
console.log(arr2_stmnt);

var arr2_expr = arr.map(x => Math.random()).filter(x => x > 0.3).map(y => Math.floor(y * 100));
console.log(arr2_expr);

// opdracht 7
console.log('opdracht7')
var foo = function foo(x) {
    if (x > 4) {
        throw new Error('x > 4')
    }

    x++

    x *= 100

    return Math.floor(x)
}
console.log([1, 2, 3, 4].map(foo))

var foo = function foo(x) {
    if (x > 4) {
        throw new Error('x > 4');
    }

    x++;

    x *= 100;

    return Math.floor(x);
}
console.log([1, 2, 3, 4].map(foo));



// opdracht 8
console.log('opdracht 8')
console.log(5 == new Number(5));                //true
console.log(new Number(5) == new Number(5));    //false
console.log(5 === new Number(5));               //true
console.log(new Number(5) === new Number(5));   //false
console.log(5 == [5]);                          //true
console.log(5 === [5]);                         //false
console.log(0 == false);                        //true
console.log(1 == true);                         //true
console.log(2 == true);                         //false
console.log('' == false);                       //false
console.log('0' == false);                      //true
console.log('' ? true : false);                 //false
console.log('0' ? true : false);                //true
console.log(false == null);                     //false
console.log(false == undefined);                //false
console.log(null == undefined);                 //true

// opdracht 9
console.log('opdracht 9')
var fibonacci_series = function (n) {
    if (n === 1) {
        return [0, 1];
    }
    else {
        var s = fibonacci_series(n - 1);
        s.push(s[s.length - 1] + s[s.length - 2]);
        return s;
    }
};

console.log(fibonacci_series(8));

console.log(
    (function (n) {
        if (n === 1) {
            return [0, 1];
        } else {
            var s = (arguments.callee(n - 1));
            s.push(s[s.length - 1] + s[s.length - 2]);
            return s
        }
    })(8)
);

// opdracht 10
console.log('opdracht 10')
var teller1 = function (n1) {
    startWaarde = n1;
    return {
        metStapGrootte: function (n2) {
            return {
                volgende: function () {
                    return startWaarde += n2;
                }
            }
        }
    }
}

const T = teller1(5).metStapGrootte(2);
console.log(T.volgende()); // 7
console.log(T.volgende()); // 9
console.log(T.volgende()); // 11
console.log(T.volgende()); // 13
console.log(T.volgende()); // 15

// opdracht 11
console.log('opdracht 11')

function foo1() {
    this.prop1 = 'prop 1 foo'
    this.prop2 = 'prop 2 foo'
}

function bar() {
    this.prop1 = 'prop 1 bar'
    this.prop2 = 'prop 2 bar'
}

bar.prototype = foo1

console.log(new foo1().prop1);
console.log(new foo1().prop2);
console.log(new bar().prop1);
console.log(new bar().prop2);  