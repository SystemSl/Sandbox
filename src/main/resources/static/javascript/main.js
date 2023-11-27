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
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount)) {
        if (checkSorted(xValues, amount)) {
            $.ajax ({
                url: "/",
                type: 'POST',
                data: {xValues_table, yValues_table}
            });
            return true;
        }
        else {
            alert("X not sorted");
            return false;
        }
    }
    else {
        alert("Undefined values found");
        return false;
    }
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
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount)) {
        if (checkSorted(xValues, amount)) {
            $.ajax ({
                url: "/",
                type: 'POST',
                data: {xValues_table1, yValues_table1}
            });
            return true;
            }
        else {
            alert("X not sorted");
            return false;
        }
    }
    else {
        alert("Undefined values found");
        return false;
    }
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
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount)) {
        if (checkSorted(xValues, amount)) {
            $.ajax ({
                url: "/",
                type: 'POST',
                data: {xValues_table2, yValues_table2}
            });
            return true;
        }
        else {
            alert("X not sorted");
            return false;
        }
    }
    else {
        alert("Undefined values found");
        return false;
    }
}

function table_arrays_result(amount, operation) {
    let yValues_op_1_a = new Array(amount);
    let yValues_op_2_a = new Array(amount);
    let yValues_op_1 = ""
    for (let i = 0; i < amount - 1; i++) {
        console.log(amount);
        console.log(operation);
        let el = document.getElementById(`operand-1-${i}`).value;
        yValues_op_1_a[i] = el;
        yValues_op_1 += el + " ";
    }
    let yValues_op_2 = ""
    for (let i = 0; i < amount - 1; i++) {
        console.log(document.getElementById(`operand-2-${i}`));
        let el = document.getElementById(`operand-2-${i}`).value;
        yValues_op_2_a[i] = el;
        yValues_op_2 += el + " ";
    }
    if (checkUndefined(yValues_op_1_a, amount) && checkUndefined(yValues_op_2_a, amount)) {
        if ((operation == "/") && ((yValues_op_2_a.indexOf('0') != -1) || (yValues_op_2_a.indexOf('0.0') != -1))) {
            alert("Division by zero");
            return false;
        }
        else {
            xValues_result = func_1_x;
            $.ajax ({
                url: "/",
                type: 'POST',
                data: {xValues_result, yValues_op_1, yValues_op_2, operation}
            });
            return true;
        }
    }
    else {
        alert("Undefined values found");
        return false;
    }
}

function functions_clear() {
    let clear = "yes";
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {clear}
    });
}

function confirm_op_2(amount) {
    let yValues = new Array(amount);
    let yValues_table2 = ""
    for (let i = 0; i < amount - 1; i++) {
        let el = document.getElementById(`operand-2-${i}`).value;
        yValues[i] = el;
        yValues_table2 += el + " ";
    }
    if (checkUndefined(yValues, amount)) {
        xValues_table2 = func_2_x;
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_table2, yValues_table2}
        });
        return true;
    }
    else {
        alert("Undefined values found");
        return false;
    }
};

function confirm_op_1(amount) {
    let yValues = new Array(amount);
    let yValues_table1 = ""
    for (let i = 0; i < amount - 1; i++) {
        let el = document.getElementById(`operand-1-${i}`).value;
        yValues[i] = el;
        yValues_table1 += el + " ";
    }
    if (checkUndefined(yValues, amount)) {
        xValues_table1 = func_1_x;
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_table1, yValues_table1}
        });
        return true;
    }
    else {
        alert("Undefined values found");
        return false;
    }
};

function function_data3() {
    source_3 = String(document.getElementById("source_3").value);
    xFrom_3 = String(document.getElementById("xFrom_3").value);
    xTo_3 = String(document.getElementById("xTo_3").value);
    count_3 = String(document.getElementById("count_3").value);
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source_3, xFrom_3, xTo_3, count_3}
    });
}

function function_data_with_c3() {
    source_3 = document.getElementById("source_3").value;
    xFrom_3 = document.getElementById("xFrom_3").value;
    xTo_3 = document.getElementById("xTo_3").value;
    count_3 = document.getElementById("count_3").value;
    c_3 = document.getElementById("c_3").value;
    $.ajax ({
        url: "/",
        type: 'POST',
        data: {source_3, xFrom_3, xTo_3, count_3, c_3}
    });
}

function table_arrays3(amount) {
    let xValues = new Array(amount);
    let yValues = new Array(amount);
    let xValues_table3 = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-3-0-${i}`).value;
        xValues[i] = el;
        xValues_table3 += el + " ";
    }
    let yValues_table3 = ""
    for (let i = 0; i < amount; i++) {
        let el = document.getElementById(`input-table-3-1-${i}`).value;
        yValues[i] = el;
        yValues_table3 += el + " ";
    }
    if (checkUndefined(xValues, amount) && checkUndefined(yValues, amount)) {
        if (checkSorted(xValues, amount)) {
            $.ajax ({
                url: "/",
                type: 'POST',
                data: {xValues_table3, yValues_table3}
            });
            return true;
            }
        else {
            alert("X not sorted");
            return false;
        }
    }
    else {
        alert("Undefined values found");
        return false;
    }
}

function confirm_op_3(amount) {
    let yValues = new Array(amount);
    let yValues_table3 = ""
    for (let i = 0; i < amount - 1; i++) {
        let el = document.getElementById(`operand-3-${i}`).value;
        yValues[i] = el;
        yValues_table3 += el + " ";
    }
    if (checkUndefined(yValues, amount)) {
        xValues_table3 = func_3_x;
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_table3, yValues_table3}
        });
        return true;
    }
    else {
        alert("Undefined values found");
        return false;
    }
};

function table_arrays_differ(amount) {
    let yValues_op_3_a = new Array(amount);
    let yValues_op_3 = ""
    for (let i = 0; i < amount - 1; i++) {
        let el = document.getElementById(`operand-3-${i}`).value;
        yValues_op_3_a[i] = el;
        yValues_op_3 += el + " ";
    }
    if (checkUndefined(yValues_op_3_a, amount)) {
        xValues_differ = func_3_x;
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {xValues_differ, yValues_op_3}
        });
        return true;
    }
    else {
        alert("Undefined values found");
        return false;
    }
}