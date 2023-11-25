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

function function_data() {
    source = String(document.getElementById("form_for_function").value);
    xFrom = String(document.getElementById("xFrom").value);
    xTo = String(document.getElementById("xTo").value);
    count = String(document.getElementById("count").value);
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source, xFrom, xTo, count}
    });
}

function function_data_with_c() {
    source = document.getElementById("form_for_function").value;
    xFrom = document.getElementById("xFrom").value;
    xTo = document.getElementById("xTo").value;
    count = document.getElementById("count").value;
    c = document.getElementById("c").value;
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source, xFrom, xTo, count, c}
    });
}

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

function function_data1() {
    source_1 = String(document.getElementById("source_1").value);
    xFrom_1 = String(document.getElementById("xFrom_1").value);
    xTo_1 = String(document.getElementById("xTo_1").value);
    count_1 = String(document.getElementById("count_1").value);
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source_1, xFrom_1, xTo_1, count_1}
    });
}

function function_data_with_c1() {
    source_1 = document.getElementById("source_1").value;
    xFrom_1 = document.getElementById("xFrom_1").value;
    xTo_1 = document.getElementById("xTo_1").value;
    count_1 = document.getElementById("count_1").value;
    c_1 = document.getElementById("c_1").value;
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source_1, xFrom_1, xTo_1, count_1, c_1}
    });
}

function table_arrays1(amount) {
    let xValues = new Array(amount);
    let yValues = new Array(amount);
    let xValues_table1 = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-1-0-${i}`).value;
        xValues[i] = el;
        xValues_table1 += el + " ";
    }
    let yValues_table1 = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-1-1-${i}`).value;
        yValues[i] = el;
        yValues_table1 += el + " ";
    }
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount) && checkSorted(xValues, amount)) {
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_table1, yValues_table1}
        });
        return true;
    }
    else return false;
}

function function_data2() {
    source_2 = String(document.getElementById("source_2").value);
    xFrom_2 = String(document.getElementById("xFrom_2").value);
    xTo_2 = String(document.getElementById("xTo_2").value);
    count_2 = String(document.getElementById("count_2").value);
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source_2, xFrom_2, xTo_2, count_2}
    });
}

function function_data_with_c2() {
    source_2 = document.getElementById("source_2").value;
    xFrom_2 = document.getElementById("xFrom_2").value;
    xTo_2 = document.getElementById("xTo_2").value;
    count_2 = document.getElementById("count_2").value;
    c_2 = document.getElementById("c_2").value;
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source_2, xFrom_2, xTo_2, count_2, c_2}
    });
}

function table_arrays2(amount) {
    let xValues = new Array(amount);
    let yValues = new Array(amount);
    let xValues_table2 = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-2-0-${i}`).value;
        xValues[i] = el;
        xValues_table2 += el + " ";
    }
    let yValues_table2 = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-2-1-${i}`).value;
        yValues[i] = el;
        yValues_table2 += el + " ";
    }
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount) && checkSorted(xValues, amount)) {
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_table2, yValues_table2}
        });
        return true;
    }
    else return false;
}

function functions_clear() {
    let clear = "yes";
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {clear}
    });
}