btn_operand_1_table = document.getElementById("operand_1_table");
btn_operand_1_function = document.getElementById("operand_1_function");
element_wise_operand_1_close = document.getElementById("element_wise_operand_1_close");
modal_container_element_wise_operand_1 = document.getElementById("modal_container_element_wise_operand_1");
element_wise_1 = document.getElementById("element_wise_1");

btn_operand_1_table.addEventListener('click', () => {
    el = document.getElementById("f1");
    if (el != null)
        el.remove();
    f1 = document.createElement('form');
    f1.setAttribute('id', "f1");
    f1.setAttribute('target', "votar");
    document.getElementById("element_wise_op_1").appendChild(f1);
    modal_container_element_wise_operand_1.classList.add("show");
    form_amount_1 = document.createElement('input');
    form_amount_1.setAttribute('type', "number");
    form_amount_1.setAttribute('placeholder', "Input amount of elements");
    form_amount_1.setAttribute('class', "form-control mb-2");
    form_amount_1.setAttribute('id', "form_amount_1");
    f1.appendChild(form_amount_1);
    form_amount_1_submit = document.createElement('button');
    form_amount_1_submit.setAttribute('type', "submit");
    form_amount_1_submit.setAttribute('class', "btn btn-success mb-2");
    form_amount_1_submit.textContent = "Confirm";
    f1.appendChild(form_amount_1_submit);
    form_amount_1_submit.addEventListener('click', () => {
        if ((form_amount_1.value < 2) || !isInt(form_amount_1.value)) {
            alert("Incorrect amount!")
        }
        else {
            table_form_1 = document.createElement('div');
            f1.appendChild(table_form_1);
            table_form_1.setAttribute('style', "overflow-x: auto")
            form_amount_1.classList.add("vanish");
            form_amount_1_submit.classList.add("vanish");
            tbl1  = document.createElement('table');
            tbl1.style.border = '1px solid black';

            for(var i = 0; i < 2; i++){
                var tr = tbl1.insertRow();
                let el, td;
                for(var j = 0; j <= form_amount_1.value; j++){
                    td = tr.insertCell();
                    if (i == 0 && j == 0) {
                        td.appendChild(document.createTextNode('X'));
                    }
                    else if (i == 1 && j == 0) {
                        td.appendChild(document.createTextNode('Y'));
                    }
                    else {
                        el = document.createElement('input');
                        el.value = '0';
                        el.setAttribute('type', 'number');
                        el.setAttribute('id', `input-table-1-${i}-${j-1}`);
                        td.appendChild(el);
                    }
                }
            }
            table_form_1.appendChild(tbl1);
            form_table_1_submit = document.createElement('button');
            form_table_1_submit.setAttribute('type', "submit");
            form_table_1_submit.setAttribute('class', "btn btn-success mb-2 mt-2");
            form_table_1_submit.textContent = "Confirm";
            f1.appendChild(form_table_1_submit);
            form_table_1_submit.addEventListener('click', () => {
                if (table_arrays1(form_amount_1.value)) {
                    modal_container_element_wise_operand_1.classList.remove("show");
                }
                else
                    alert("Structure of the tabulated function is broken!");
            });
        }
    });
});

btn_operand_1_function.addEventListener('click', () => {
    el = document.getElementById("f1");
    if (el != null)
        el.remove();
    f1 = document.createElement('form');
    f1.setAttribute('id', "f1");
    f1.setAttribute('target', "votar");
    document.getElementById("element_wise_op_1").appendChild(f1);
    modal_container_element_wise_operand_1.classList.add("show");
    sel  = document.createElement('select');
    sel.style.width = "300px";
    sel.setAttribute('id', "source_1");
    sel.setAttribute('class', "form-select function_alphabet mb-1");
    let opt = document.createElement('option');
    opt.setAttribute('selected', true);
    opt.textContent = funcs[0];
    opt.setAttribute('value', `${funcs[0]}`);
    sel.appendChild(opt);
    for (let i = 1; i < funcs.length; i++) {
        opt = document.createElement('option');
        opt.textContent = funcs[i];
        opt.setAttribute('value', `${funcs[i]}`);
        sel.appendChild(opt);
    }
    f1.appendChild(sel);
    xFrom_1 = document.createElement('input');
    xFrom_1.setAttribute('type', "number");
    xFrom_1.setAttribute('placeholder', "Input x1");
    xFrom_1.setAttribute('class', "form-control mb-1");
    xFrom_1.setAttribute('id', "xFrom_1");
    xFrom_1.style.width = "150px";
    f1.appendChild(xFrom_1);
    xTo_1 = document.createElement('input');
    xTo_1.setAttribute('type', "number");
    xTo_1.setAttribute('placeholder', "Input x2");
    xTo_1.setAttribute('class', "form-control mb-1");
    xTo_1.setAttribute('id', "xTo_1");
    xTo_1.style.width = "150px";
    f1.appendChild(xTo_1);
    count_1 = document.createElement('input');
    count_1.setAttribute('type', "number");
    count_1.setAttribute('placeholder', "Input count");
    count_1.setAttribute('class', "form-control mb-1");
    count_1.setAttribute('id', "count_1");
    count_1.style.width = "150px";
    f1.appendChild(count_1);
    func_submit_1 = document.createElement('button');
    func_submit_1.setAttribute('type', "submit");
    func_submit_1.setAttribute('class', "btn btn-success mb-2");
    func_submit_1.textContent = "Confirm";
    f1.appendChild(func_submit_1);
    func_submit_1.addEventListener('click', () => {
            if ((count_1.value < 2) || !isInt(count_1.value)) {
                alert("Incorrect count!")
            }
            else if (!checkUndefinedNumber(xFrom_1.value)) {
                alert("Undefined x1!")
            }
            else if (!checkUndefinedNumber(xTo_1.value)) {
                alert("Undefined x2!")
            }
            else if (xTo_1.value == xFrom_1.value) {
                alert("x1 = x2!")
            }
            else {
                document.getElementById("source_1").setAttribute('disabled', true);
                if (document.getElementById("source_1").value == "Const function") {
                    func_submit_1.classList.add("vanish");
                    xFromT_1 = document.createElement('div');
                    xFromT_1.setAttribute('class', "mb-1 h5");
                    xFromT_1.textContent = `x1: ${xFrom_1.value}`
                    f1.appendChild(xFromT_1);
                    xToT_1 = document.createElement('div');
                    xToT_1.setAttribute('class', "mb-1 h5");
                    xToT_1.textContent = `x2: ${xTo_1.value}`
                    f1.appendChild(xToT_1);
                    countT_1 = document.createElement('div');
                    countT_1.setAttribute('class', "mb-1 h5");
                    countT_1.textContent = `count: ${count_1.value}`
                    f1.appendChild(countT_1);
                    document.getElementById("xFrom_1").classList.add("vanish");
                    document.getElementById("xTo_1").classList.add("vanish");
                    document.getElementById("count_1").classList.add("vanish");
                    c_1 = document.createElement('input');
                    c_1.setAttribute('type', "number");
                    c_1.setAttribute('placeholder', "Input const");
                    c_1.setAttribute('class', "form-control mb-1 mt-1");
                    c_1.setAttribute('id', "c_1");
                    c_1.style.width = "150px";
                    f1.appendChild(c_1);
                    func_submit_1_with_c = document.createElement('button');
                    func_submit_1_with_c.setAttribute('type', "submit");
                    func_submit_1_with_c.setAttribute('class', "btn btn-success mb-2");
                    func_submit_1_with_c.textContent = "Confirm";
                    f1.appendChild(func_submit_1_with_c);
                    func_submit_1_with_c.addEventListener('click', () => {
                        if (!checkUndefinedNumber(c_1.value)) {
                            alert("Incorrect const!")
                        }
                        else {
                            function_data_with_c1();
                            modal_container_element_wise_operand_1.classList.remove("show");
                        }
                    });
                }
                else {
                    function_data1();
                    modal_container_element_wise_operand_1.classList.remove("show");
                }
            }
        });
});

element_wise_operand_1_close.addEventListener('click', () => {
    modal_container_element_wise_operand_1.classList.remove("show");
});