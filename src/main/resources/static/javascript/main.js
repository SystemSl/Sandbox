// Element-wise operations

const element_wise_operations_open = document.getElementById('element_wise_operations_open');
const modal_container_element_wise_operations = document.getElementById('modal_container_element_wise_operations');
const element_wise_operations_close = document.getElementById('element_wise_operations_close');

element_wise_operations_open.addEventListener('click', () => {
    modal_container_element_wise_operations.classList.add("show");
});

element_wise_operations_close.addEventListener('click', () => {
    modal_container_element_wise_operations.classList.remove("show");
});

// Differentiation

const differentiation_open = document.getElementById('differentiation_open');
const modal_container_differentiation = document.getElementById('modal_container_differentiation');
const differentiation_close = document.getElementById('differentiation_close');

differentiation_open.addEventListener('click', () => {
    modal_container_differentiation.classList.add("show");
});

differentiation_close.addEventListener('click', () => {
    modal_container_differentiation.classList.remove("show");
});

// Integral

const integral_open = document.getElementById('integral_open');
const modal_container_integral = document.getElementById('modal_container_integral');
const integral_close = document.getElementById('integral_close');

integral_open.addEventListener('click', () => {
    modal_container_integral.classList.add("show");
});

integral_close.addEventListener('click', () => {
    modal_container_integral.classList.remove("show");
});

// Settings

const settings_open = document.getElementById('settings_open');
const modal_container_settings = document.getElementById('modal_container_settings');
const settings_close = document.getElementById('settings_close');

settings_open.addEventListener('click', () => {
    modal_container_settings.classList.add("show");
});

settings_close.addEventListener('click', () => {
    modal_container_settings.classList.remove("show");
});

function table_arrays(amount) {
    let xValues = new Array(amount);
    let yValues = new Array(amount);
    let xValues_table = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-0-${i}`).value;
        xValues[i] = el;
        xValues_table += el + " ";
    }
    let yValues_table = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-1-${i}`).value;
        yValues[i] = el;
        yValues_table += el + " ";
    }
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount) && checkSorted(xValues, amount)) {
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_table, yValues_table}
        });
        return true;
    }
    else return false;
}

function checkUndefined(ar, amount) {
    if (ar[0] == undefined)
            return false;
    let i = 1;
    while (i < amount) {
        if ((ar[i-1] == undefined) || (ar[(i++)-1] == ""))
            return false;
    }
    return true;
}

function checkUndefinedNumber(num) {
    if ((num == undefined) || (num == ""))
        return false;
    else
        return true;
}

function checkSorted(ar, amount) {
    let i = 1;
    while (i < amount) {
        if (parseFloat(ar[i]) <= parseFloat(ar[(i++)-1]))
            return false;
    }
    return true;
}

function isInt(value) {
  return !isNaN(value) &&
         parseInt(Number(value)) == value &&
         !isNaN(parseInt(value, 10));
}