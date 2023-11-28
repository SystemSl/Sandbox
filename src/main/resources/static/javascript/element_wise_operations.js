const element_wise_operations_open = document.getElementById('element_wise_operations_open');
const modal_container_element_wise_operations = document.getElementById('modal_container_element_wise_operations');
const element_wise_operations_close = document.getElementById('element_wise_operations_close');

element_wise_operations_open.addEventListener('click', () => {
    modal_container_element_wise_operations.classList.add("show");
});

element_wise_operations_close.addEventListener('click', () => {
    modal_container_element_wise_operations.classList.remove("show");
    functions_clear();
    location.reload();
});

if (func_1_x != "") {
    modal_container_element_wise_operations.classList.add("show");
    func_1_x_a = func_1_x.split(' ');
    func_1_y_a = func_1_y.split(' ');

    element_wise_operand_1_area = document.createElement('div');
    element_wise_operand_1_area.setAttribute('id', "element_wise_operand_1_area");

    document.getElementById('element_wise_1').appendChild(element_wise_operand_1_area);

    element_wise_operand_1_form = document.createElement('form');
    element_wise_operand_1_form.setAttribute('id', "element_wise_operand_1_form");
    element_wise_operand_1_area.appendChild(element_wise_operand_1_form);

    tbl  = document.createElement('table');
    tbl.style.border = '1px solid black';

    for(var i = 0; i < func_1_x_a.length; i++) {
        var tr = tbl.insertRow();
        let el, td;
        for(var j = 0; j < 2; j++){
             td = tr.insertCell();
             if (i == 0 && j == 0) {
                td.appendChild(document.createTextNode('X'));
             }
             else if (i == 0 && j == 1) {
                td.appendChild(document.createTextNode('Y'));
             }
             else {
                if (j == 0) {
                    td.appendChild(document.createTextNode(func_1_x_a[i-1]));
                }
                else {
                    el = document.createElement('input');
                    el.value = func_1_y_a[i-1];
                    el.setAttribute('type', 'number');
                    el.setAttribute('id', `operand-1-${i-1}`);
                    td.appendChild(el);
                }
            }
        }
    }
    element_wise_operand_1_form.setAttribute('style', "display: flex; align-items: center; justify-content: center; text-align: center;");
    operand_1_table = document.createElement('div');
    operand_1_table.setAttribute('style', "max-height: 400px; overflow-x: auto")
    element_wise_operand_1_form.appendChild(operand_1_table);
    operand_1_table.appendChild(tbl);

    btn = document.createElement('button');
    btn.classList.add('btn');
    btn.classList.add('btn-success');
    btn.classList.add('mt-3');
    btn.textContent = "Confirm changes";
    btn.setAttribute('style', "margin-right: 10px");
    element_wise_operand_1_area.appendChild(btn);
    btn.addEventListener('click', () => {
        length = func_1_x.split(' ').length;
        if (confirm_op_1(length))
            setTimeout(() => { location.reload(); }, 1000);
        });

    btn = document.createElement('a');
    btn.classList.add('btn');
    btn.classList.add('btn-warning');
    btn.classList.add('mt-3');
    btn.setAttribute('href', "/WebOutput/tabfunc_1");
    btn.setAttribute('download', "tabulated_function");
    btn.textContent = "Save as";
    element_wise_operand_1_area.appendChild(btn);
}

file_op_1_submit = document.getElementById("file_op_1_submit");
file_op_1_submit.addEventListener('click', () => {
    if(document.querySelector("#file_op_1").value == '') {
        console.log('No file selected');
        return;
    }
    else {
        file_1 = document.getElementById("file_op_1").value.split(/(\\|\/)/g).pop();
        $.ajax ({
                url: "/",
                type: 'POST',
                data: {file_1}
        });
        setTimeout(() => { location.reload(); }, 1000);
    }
});

if (func_2_x != "") {
    modal_container_element_wise_operations.classList.add("show");
    func_2_x_a = func_2_x.split(' ');
    func_2_y_a = func_2_y.split(' ');

    element_wise_operand_2_area = document.createElement('div');
    element_wise_operand_2_area.setAttribute('id', "element_wise_operand_2_area");

    document.getElementById('element_wise_2').appendChild(element_wise_operand_2_area);

    element_wise_operand_2_form = document.createElement('form');
    element_wise_operand_2_form.setAttribute('id', "element_wise_operand_2_form");
    element_wise_operand_2_area.appendChild(element_wise_operand_2_form);

    tbl  = document.createElement('table');
    tbl.style.border = '1px solid black';

    for(var i = 0; i < func_2_x_a.length; i++) {
        var tr = tbl.insertRow();
        let el, td;
        for(var j = 0; j < 2; j++){
             td = tr.insertCell();
             if (i == 0 && j == 0) {
                td.appendChild(document.createTextNode('X'));
             }
             else if (i == 0 && j == 1) {
                td.appendChild(document.createTextNode('Y'));
             }
             else {
                if (j == 0) {
                    td.appendChild(document.createTextNode(func_2_x_a[i-1]));
                }
                else {
                    el = document.createElement('input');
                    el.value = func_2_y_a[i-1];
                    el.setAttribute('type', 'number');
                    el.setAttribute('id', `operand-2-${i-1}`);
                    td.appendChild(el);
                }
            }
        }
    }
    element_wise_operand_2_form.setAttribute('style', "display: flex; align-items: center; justify-content: center; text-align: center;");
    operand_2_table = document.createElement('div');
    operand_2_table.setAttribute('style', "max-height: 400px; overflow-x: auto")
    element_wise_operand_2_form.appendChild(operand_2_table);
    operand_2_table.appendChild(tbl);

    btn = document.createElement('button');
    btn.classList.add('btn');
    btn.classList.add('btn-success');
    btn.classList.add('mt-3');
    btn.textContent = "Confirm changes";
    btn.setAttribute('style', "margin-right: 10px");
    element_wise_operand_2_area.appendChild(btn);
    btn.addEventListener('click', () => {
        length = func_2_x.split(' ').length;
        if (confirm_op_2(length))
            setTimeout(() => { location.reload(); }, 1000);
    });

    btn = document.createElement('a');
    btn.classList.add('btn');
    btn.classList.add('btn-warning');
    btn.classList.add('mt-3');
    btn.setAttribute('href', "/WebOutput/tabfunc_2");
    btn.setAttribute('download', "tabulated_function-2");
    btn.textContent = "Save as";
    element_wise_operand_2_area.appendChild(btn);
}

file_op_2_submit = document.getElementById("file_op_2_submit");
file_op_2_submit.addEventListener('click', () => {
    if(document.querySelector("#file_op_2").value == '') {
        console.log('No file selected');
        return;
    }
    else {
        file_2 = document.getElementById("file_op_2").value.split(/(\\|\/)/g).pop();
        $.ajax ({
                url: "/",
                type: 'POST',
                data: {file_2}
        });
        setTimeout(() => { location.reload(); }, 1000);
    }
});

confirm_operation = document.getElementById("confirm_operation");
confirm_operation.addEventListener('click', () => {
    if (func_1_x != "" && func_2_x != "") {
        if (func_1_x != func_2_x) {
            alert("Operands have different X");
        }
        else {
            select_operation = document.getElementById("select_operation");
            if (table_arrays_result(func_1_x.split(' ').length, select_operation.value)) {
                setTimeout(() => { location.reload(); }, 1000);
            }
        }
    }
});

if (element_wise_result_x != "") {
    modal_container_element_wise_operations.classList.add("show");
    element_wise_result_x_a = element_wise_result_x.split(' ');
    element_wise_result_y_a = element_wise_result_y.split(' ');

    element_wise_result_area = document.createElement('div');
    element_wise_result_area.setAttribute('id', "element_wise_result_area");

    document.getElementById('element_wise_result').appendChild(element_wise_result_area);

    tbl  = document.createElement('table');
    tbl.style.border = '1px solid black';

    for(var i = 0; i < element_wise_result_x_a.length; i++) {
        var tr = tbl.insertRow();
        let el, td;
        for(var j = 0; j < 2; j++){
            td = tr.insertCell();
            if (i == 0 && j == 0) {
                td.appendChild(document.createTextNode('X'));
            }
            else if (i == 0 && j == 1) {
                td.appendChild(document.createTextNode('Y'));
            }
            else {
                if (j == 0) {
                    td.appendChild(document.createTextNode(element_wise_result_x_a[i-1]));
                }
                else {
                    td.appendChild(document.createTextNode(element_wise_result_y_a[i-1]));
                }
            }
        }
    }
    element_wise_result_area.setAttribute('style', "display: flex; align-items: center; justify-content: center; text-align: center;");
    result_table = document.createElement('div');
    result_table.setAttribute('style', "max-height: 400px; overflow-x: auto")
    element_wise_result_area.appendChild(result_table);
    result_table.appendChild(tbl);
    btn = document.createElement('a');
    btn.classList.add('btn');
    btn.classList.add('btn-warning');
    btn.classList.add('mt-3');
    btn.setAttribute('href', "/WebOutput/tabfunc_result");
    btn.setAttribute('download', "tabulated_function-result");
    btn.textContent = "Save as";
    element_wise_result.appendChild(btn);
}