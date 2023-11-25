btn_operand_2_table = document.getElementById("operand_2_table");
btn_operand_2_function = document.getElementById("operand_2_function");
element_wise_operand_2_close = document.getElementById("element_wise_operand_2_close");
modal_container_element_wise_operand_2 = document.getElementById("modal_container_element_wise_operand_2");
element_wise_2 = document.getElementById("element_wise_2");

btn_operand_2_table.addEventListener('click', () => {
    el = document.getElementById("f2");
    if (el != null)
        el.remove();
    f2 = document.createElement('form');
    f2.setAttribute('id', "f2");
    f2.setAttribute('target', "votar");
    document.getElementById("element_wise_op_2").appendChild(f2);
    modal_container_element_wise_operand_2.classList.add("show");
    form_amount_2 = document.createElement('input');
    form_amount_2.setAttribute('type', "number");
    form_amount_2.setAttribute('placeholder', "Input amount of elements");
    form_amount_2.setAttribute('class', "form-control mb-2");
    form_amount_2.setAttribute('id', "form_amount_2");
    f2.appendChild(form_amount_2);
    form_amount_2_submit = document.createElement('button');
    form_amount_2_submit.setAttribute('type', "submit");
    form_amount_2_submit.setAttribute('class', "btn btn-success mb-2");
    form_amount_2_submit.textContent = "Confirm";
    f2.appendChild(form_amount_2_submit);
    form_amount_2_submit.addEventListener('click', () => {
        if ((form_amount_2.value < 2) || !isInt(form_amount_2.value)) {
            alert("Incorrect amount!")
        }
        else {
            table_form_2 = document.createElement('div');
            f2.appendChild(table_form_2);
            table_form_2.setAttribute('style', "overflow-x: auto")
            form_amount_2.classList.add("vanish");
            form_amount_2_submit.classList.add("vanish");
            tbl2  = document.createElement('table');
            tbl2.style.border = '1px solid black';

            for(var i = 0; i < 2; i++){
                var tr = tbl2.insertRow();
                let el, td;
                for(var j = 0; j <= form_amount_2.value; j++){
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
                        el.setAttribute('id', `input-table-2-${i}-${j-1}`);
                        td.appendChild(el);
                    }
                }
            }
            table_form_2.appendChild(tbl2);
            form_table_2_submit = document.createElement('button');
            form_table_2_submit.setAttribute('type', "submit");
            form_table_2_submit.setAttribute('class', "btn btn-success mb-2 mt-2");
            form_table_2_submit.textContent = "Confirm";
            f2.appendChild(form_table_2_submit);
            form_table_2_submit.addEventListener('click', () => {
                if (table_arrays2(form_amount_2.value)) {
                    setTimeout(() => { location.reload(); }, 500);
                }
                else
                    alert("Structure of the tabulated function is broken!");
            });
        }
    });
});

btn_operand_2_function.addEventListener('click', () => {
    el = document.getElementById("f2");
    if (el != null)
        el.remove();
    f2 = document.createElement('form');
    f2.setAttribute('id', "f2");
    f2.setAttribute('target', "votar");
    document.getElementById("element_wise_op_2").appendChild(f2);
    modal_container_element_wise_operand_2.classList.add("show");
    sel  = document.createElement('select');
    sel.style.width = "300px";
    sel.setAttribute('id', "source_2");
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
    f2.appendChild(sel);
    xFrom_2 = document.createElement('input');
    xFrom_2.setAttribute('type', "number");
    xFrom_2.setAttribute('placeholder', "Input x1");
    xFrom_2.setAttribute('class', "form-control mb-1");
    xFrom_2.setAttribute('id', "xFrom_2");
    xFrom_2.style.width = "150px";
    f2.appendChild(xFrom_2);
    xTo_2 = document.createElement('input');
    xTo_2.setAttribute('type', "number");
    xTo_2.setAttribute('placeholder', "Input x2");
    xTo_2.setAttribute('class', "form-control mb-1");
    xTo_2.setAttribute('id', "xTo_2");
    xTo_2.style.width = "150px";
    f2.appendChild(xTo_2);
    count_2 = document.createElement('input');
    count_2.setAttribute('type', "number");
    count_2.setAttribute('placeholder', "Input count");
    count_2.setAttribute('class', "form-control mb-1");
    count_2.setAttribute('id', "count_2");
    count_2.style.width = "150px";
    f2.appendChild(count_2);
    func_submit_2 = document.createElement('button');
    func_submit_2.setAttribute('type', "submit");
    func_submit_2.setAttribute('class', "btn btn-success mb-2");
    func_submit_2.textContent = "Confirm";
    f2.appendChild(func_submit_2);
    func_submit_2.addEventListener('click', () => {
            if ((count_2.value < 2) || !isInt(count_2.value)) {
                alert("Incorrect count!")
            }
            else if (!checkUndefinedNumber(xFrom_2.value)) {
                alert("Undefined x1!")
            }
            else if (!checkUndefinedNumber(xTo_2.value)) {
                alert("Undefined x2!")
            }
            else if (xTo_2.value == xFrom_2.value) {
                alert("x1 = x2!")
            }
            else {
                document.getElementById("source_2").setAttribute('disabled', true);
                if (document.getElementById("source_2").value == "Const function") {
                    func_submit_2.classList.add("vanish");
                    xFromT_2 = document.createElement('div');
                    xFromT_2.setAttribute('class', "mb-1 h5");
                    xFromT_2.textContent = `x1: ${xFrom_2.value}`
                    f2.appendChild(xFromT_2);
                    xToT_2 = document.createElement('div');
                    xToT_2.setAttribute('class', "mb-1 h5");
                    xToT_2.textContent = `x2: ${xTo_2.value}`
                    f2.appendChild(xToT_2);
                    countT_2 = document.createElement('div');
                    countT_2.setAttribute('class', "mb-1 h5");
                    countT_2.textContent = `count: ${count_2.value}`
                    f2.appendChild(countT_2);
                    document.getElementById("xFrom_2").classList.add("vanish");
                    document.getElementById("xTo_2").classList.add("vanish");
                    document.getElementById("count_2").classList.add("vanish");
                    c_2 = document.createElement('input');
                    c_2.setAttribute('type', "number");
                    c_2.setAttribute('placeholder', "Input const");
                    c_2.setAttribute('class', "form-control mb-1 mt-1");
                    c_2.setAttribute('id', "c_2");
                    c_2.style.width = "150px";
                    f2.appendChild(c_2);
                    func_submit_2_with_c = document.createElement('button');
                    func_submit_2_with_c.setAttribute('type', "submit");
                    func_submit_2_with_c.setAttribute('class', "btn btn-success mb-2");
                    func_submit_2_with_c.textContent = "Confirm";
                    f2.appendChild(func_submit_2_with_c);
                    func_submit_2_with_c.addEventListener('click', () => {
                        if (!checkUndefinedNumber(c_2.value)) {
                            alert("Incorrect const!")
                        }
                        else {
                            function_data_with_c2();
                            setTimeout(() => { location.reload(); }, 500);
                        }
                    });
                }
                else {
                    function_data2();
                    setTimeout(() => { location.reload(); }, 500);
                }
            }
        });
});

element_wise_operand_2_close.addEventListener('click', () => {
    modal_container_element_wise_operand_2.classList.remove("show");
});