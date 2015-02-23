/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Define the state machine for the calculator, which will be driven by the events of the calculator buttons.
var comMachine = StateMachine.create({
  initial: 'WAITING_FOR_FIRST_ARGUMENT',
  //A generic handling of an improper calculating sequence
  error: function(eventName, from, to, args, errorCode, errorMessage) {
    alert('This action is currently not alowed, transition from: '+from+' to: ' + to +' by: ' + eventName + ', msg: ' + errorMessage);
  },
  events: [
    //Waitinig for the first argument
    { name: 'number',   from: 'WAITING_FOR_FIRST_ARGUMENT',    to: 'INPUTTING_FIRST_ARGUMENT' },
    { name: 'dot',      from: 'WAITING_FOR_FIRST_ARGUMENT',    to: 'INPUTTING_FIRST_ARGUMENT'  },
    { name: 'clr',      from: 'WAITING_FOR_FIRST_ARGUMENT',    to: 'WAITING_FOR_FIRST_ARGUMENT'  },
    //Inputting the first argument
    { name: 'number',   from: 'INPUTTING_FIRST_ARGUMENT',      to: 'INPUTTING_FIRST_ARGUMENT' },
    { name: 'dot',      from: 'INPUTTING_FIRST_ARGUMENT',      to: 'INPUTTING_FIRST_ARGUMENT'  },
    { name: 'clr',      from: 'INPUTTING_FIRST_ARGUMENT',      to: 'WAITING_FOR_FIRST_ARGUMENT'  },
    //An operation with the second argument
    { name: 'plus',     from: 'INPUTTING_FIRST_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'minus',    from: 'INPUTTING_FIRST_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'divide',   from: 'INPUTTING_FIRST_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'multiply', from: 'INPUTTING_FIRST_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'sqrt',     from: 'INPUTTING_FIRST_ARGUMENT',    to: 'RESULT_READY'  },
    { name: 'error',    from: 'INPUTTING_FIRST_ARGUMENT',    to: 'ERROR_RESULT'  },
     //Waitinig for the second argument
    { name: 'number',   from: 'WAITING_FOR_SECOND_ARGUMENT',    to: 'INPUTTING_SECOND_ARGUMENT' },
    { name: 'dot',      from: 'WAITING_FOR_SECOND_ARGUMENT',    to: 'INPUTTING_SECOND_ARGUMENT'  },
    { name: 'clr',      from: 'WAITING_FOR_SECOND_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
   //Inputting the second argument
    { name: 'number',   from: 'INPUTTING_SECOND_ARGUMENT',    to: 'INPUTTING_SECOND_ARGUMENT' },
    { name: 'dot',      from: 'INPUTTING_SECOND_ARGUMENT',    to: 'INPUTTING_SECOND_ARGUMENT'  },
    { name: 'clr',      from: 'INPUTTING_SECOND_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    //An operation after the second argument - A binary operation
    { name: 'plus',     from: 'INPUTTING_SECOND_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'minus',    from: 'INPUTTING_SECOND_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'divide',   from: 'INPUTTING_SECOND_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'multiply', from: 'INPUTTING_SECOND_ARGUMENT',    to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    //An operation after the second argument - A unary operation
    { name: 'sqrt',     from: 'INPUTTING_SECOND_ARGUMENT',    to: 'RESULT_READY'  },
    { name: 'procent',  from: 'INPUTTING_SECOND_ARGUMENT',    to: 'RESULT_READY' },
    { name: 'result',   from: 'INPUTTING_SECOND_ARGUMENT',    to: 'RESULT_READY' },
    { name: 'error',    from: 'INPUTTING_SECOND_ARGUMENT',    to: 'ERROR_RESULT'  },
    //Once the result is ready more operations are possible binaty and unary
    { name: 'plus',     from: 'RESULT_READY',             to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'minus',    from: 'RESULT_READY',             to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'divide',   from: 'RESULT_READY',             to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'multiply', from: 'RESULT_READY',             to: 'WAITING_FOR_SECOND_ARGUMENT'  },
    { name: 'sqrt',     from: 'RESULT_READY',             to: 'RESULT_READY'  },
    { name: 'error',    from: 'RESULT_READY',             to: 'ERROR_RESULT'  },
    { name: 'clr',      from: 'RESULT_READY',             to: 'WAITING_FOR_FIRST_ARGUMENT'  },
    { name: 'number',   from: 'RESULT_READY',             to: 'INPUTTING_FIRST_ARGUMENT' },
    { name: 'dot',      from: 'RESULT_READY',             to: 'INPUTTING_FIRST_ARGUMENT'  },
    //The last operation result in en error result
    { name: 'clr',      from: 'ERROR_RESULT',             to: 'WAITING_FOR_FIRST_ARGUMENT'  }
  ],
  callbacks: {
    onbeforenumber:  function(event, from, to, number) {
        var screen = getScreenField();
        
        if( screen.value === '0' ) {
            //If the current screen value is zerro
            if( number !== '0') {
                //And the new given number is not a zerro, then put it as
                //the actual value. The new number should not start with
                //zerro if there is no decimal point
                setScreenValue(number);
            }
        } else {
            //If the screen value is not zerro then there was already
            //some input or this is a result of previous computations/inputs.
            if( comMachine.is('WAITING_FOR_SECOND_ARGUMENT') || comMachine.is('RESULT_READY') ) {
                //If we to input the second argument then reset te screen
                setScreenValue(number);
            } else {
                //If we are inputting an argument then append the number to the value on the screen
                appendScreenValue(number);
            }
        }
        
        //Update the current screen value for convenience
        currentArgument = getScreenValue();
    },
    onbeforedot:  function(event, from, to) {
        //The decimal point - dot is being input.
        
        if( comMachine.is('WAITING_FOR_SECOND_ARGUMENT') || comMachine.is('RESULT_READY') )
        {
            //If the second argument is expected to be input
            //then reset te screen and start inputting a new double
            setScreenValue('0.');
        } else {
            //If the second argument is being input
            if( screenContainsDecimal() !== true )
            {
                //If there is no decimal point in it yet, then introduce it
                //then introduce ther decimal point into this number
                appendScreenValue('.');
            } else {
                //If there is already a decimal point in it - report an error
                alert('The decimal point is already present!');
            }
        }
        
        //Update the current screen value for convenience
        currentArgument = getScreenValue();
   },
    onbeforeplus:  function(event, from, to) {
        //The plus button is pressed, check if smething needs to be computed
        computeCurrResAndStoreNewOperation(Operations.PLUS);
    },
    onbeforeminus:  function(event, from, to) {
        //The minus button is pressed, check if smething needs to be computed
        computeCurrResAndStoreNewOperation(Operations.MINUS);
    },
    onbeforemultiply:  function(event, from, to) {
        //The multiply button is pressed, check if smething needs to be computed
        computeCurrResAndStoreNewOperation(Operations.MULTIPLY);
    },
    onbeforedivide:  function(event, from, to) {
        //The divide button is pressed, check if smething needs to be computed
        computeCurrResAndStoreNewOperation(Operations.DIVIDE);
    },
    onresult: function(event, from, to) {
        //Compute the current result and set it on the screen as current
        setScreenValue(computeResult(firstArgument, currentOperation, currentArgument));
    },
    onprocent:  function(event, from, to) {
        //compute the % of the first argument given by the second
        var secondArgumen = firstArgument / 100 * currentArgument;
        //Compute the current result and set it on the screen as current
        setScreenValue(computeResult(firstArgument, currentOperation, secondArgumen));
    },
    onsqrt:  function(event, from, to) {
        //compute the square root of the current argument
        var secondArgumen = 0;
        try {
            secondArgumen = Math.sqrt(currentArgument);
        } catch (ex) {
            alert('Computational error: '+ ex.message);
        }
        
        //If there was something previously input - some expression then compute it
        if( comMachine.is('INPUTTING_SECOND_ARGUMENT') )
        {
            //Compute the current result and set it on the screen as current
            setScreenValue(computeResult(firstArgument, currentOperation, secondArgumen));
        } else {
            //If there was nothing more to compute just set the result of the root.
            setScreenValue(secondArgumen);
        }
    },
    onclr:  function(event, from, to) {
        //Clear the screen
        setScreenValue(0);
    },
    onerror:  function(event, from, to) {
        //Clear the screen
        setScreenValue(0);
    },
    onmr:  function(event, from, to) {
        alert('The MR operation is not supported yet!');
    },
    onmp:  function(event, from, to) {
        alert('The MP operation is not supported yet!');
    },
    onmm:  function(event, from, to) {
        alert('The MM operation is not supported yet!');
    }
  }});

//Stores the available operations
var Operations = Object.freeze({
                    NONE : 0,       //Non or undefined operation
                    PLUS : 1,
                    MINUS : 2,
                    MULTIPLY : 3,
                    DIVIDE : 4,
                    PROCENT : 5,
                    SQRT : 6,
                    RESULT : 7,
                    MR : 8,         //Memory related operations, NOT SUPPORTED YET
                    MP : 9,         //Memory related operations, NOT SUPPORTED YET
                    MM : 10,        //Memory related operations, NOT SUPPORTED YET
                    CLR : 11
                });

//The first argument of the binary operation
var firstArgument = 0;
//Stores the current input argument
var currentArgument = 0;
//Stores the current operation
var currentOperation = Operations.NONE;

//This functions conputes the result of the given operation for the two given arguments.
function computeResult(firstArgument, operation, currentArgument){
    try {
        switch(operation){
            case Operations.PLUS:
                return firstArgument + currentArgument;
            case Operations.MINUS:
                return firstArgument - currentArgument;
            case Operations.MULTIPLY:
                return firstArgument * currentArgument;
            case Operations.DIVIDE:
                return firstArgument / currentArgument;
            case Operations.PROCENT:
                return firstArgument / currentArgument;
            case Operations.SQRT:
                return firstArgument / currentArgument;
            default:
                alert('Unsupported operation ' + operation);
        }
    } catch (ex) {
        alert('Computational error: '+ ex.message);
    }
    return NaN;
}

/* This function is called when an operation button is called.
 * Here we should check if there was already an expression
 * input that needed computations. If yes, then these computations
 * need to be done first.
 */
function computeCurrResAndStoreNewOperation(newOperation) {
    //If there was something previously input - some expression then first compute it
    if( comMachine.is('INPUTTING_SECOND_ARGUMENT') )
    {
        //Compute the current result and set it on the screen as current
        setScreenValue(computeResult(firstArgument, currentOperation, currentArgument));
    } else {
        firstArgument = currentArgument;
    }
    currentOperation = newOperation;
}

//Allows to obtain the current value displayed in the calculator window.
function getScreenValue(){
    var screen = getScreenField();
    return parseFloat(screen.value);
}

/*Allows to obtain the DOM element of the calculator
 *screen, storing the current result value
 */
function getScreenField() {
    var screen = document.getElementById("calcScreen");
    if( screen === null) {
        alert('The screen is not found!');
    }
    return screen;
}

/*Allows to set the current result value on the screen
 *and store it in the internal variable of the module
 */
function setScreenValue(value) {
    var screen = getScreenField();
    if( !isNaN(value)) {
        screen.value = value;
    } else {
        screen.value = 'ERROR';
    }
    currentArgument = value;
}

/* Allows to append the given value to the value on the calculator's screen
 * This function is needed for inputting the digits and commas.
 */
function appendScreenValue(value) {
    var screen = getScreenField();
    screen.value += value;
}

/*
 * Allows to check whether the value on the screen contains a decimal ponit
 */
function screenContainsDecimal() {
    var screen = getScreenField();
    return (screen.value.indexOf('.') !== -1);
}
