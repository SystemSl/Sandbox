// Settings

const settings_open = document.getElementById('settings_open');
const modal_container_settings = document.getElementById('modal_container_settings');
const settings_close = document.getElementById('settings_close');

settings_open.addEventListener('click', () => {
    el = document.getElementById("container_of_form_for_factory");
    if (el != null)
        el.remove();
    container_of_form_for_factory = document.createElement('div');
    container_of_form_for_factory.setAttribute('id', "container_of_form_for_factory");
    document.getElementById("form_for_factory").appendChild(container_of_form_for_factory);
    sel  = document.createElement('select');
    sel.style.width = "300px";
    sel.setAttribute('id', "form_for_factories");
    sel.setAttribute('class', "form-select mb-1");
    let opt = document.createElement('option');
    opt.setAttribute('selected', true);
    opt.textContent = "Array";
    opt.setAttribute('value', "Array");
    sel.appendChild(opt);
    opt = document.createElement('option');
    opt.textContent = "Linked list";
    opt.setAttribute('value', "Linked list");
    sel.appendChild(opt);
    document.getElementById("container_of_form_for_factory").appendChild(sel);
    container_of_form_for_uploadpath = document.createElement('div');
    container_of_form_for_uploadpath.setAttribute('id', "container_of_form_for_uploadpath");
    document.getElementById("form_for_factory").appendChild(container_of_form_for_uploadpath);
    field = document.createElement('input');
    field.setAttribute('type', "text");
    field.setAttribute('placeholder', "Input upload path");
    field.setAttribute('id', "form_for_uploadpath");
    container_of_form_for_uploadpath.appendChild(field);
    factory_submit = document.createElement('button');
    factory_submit.setAttribute('type', "submit");
    factory_submit.setAttribute('class', "btn btn-success mb-2 mt-1");
    factory_submit.textContent = "Confirm";
    d = document.createElement('div');
    container_of_form_for_uploadpath.appendChild(d)
    d.appendChild(factory_submit);
    factory_submit.addEventListener('click', () => {
        document.getElementById("form_for_factories").setAttribute('disabled', true);
        let cur_fac = document.getElementById("form_for_factories").value;
        $.ajax ({
            url: "/",
            type: 'POST',
            data: {cur_fac}
        });
        if (document.getElementById("form_for_uploadpath").value != "") {
            uploadpath = document.getElementById("form_for_uploadpath").value;
            $.ajax ({
                        url: "/",
                        type: 'POST',
                        data: {uploadpath}
            });
        }
        factory_submit.remove();
        modal_container_settings.classList.remove("show");
    });
    modal_container_settings.classList.add("show");
});

settings_close.addEventListener('click', () => {
    modal_container_settings.classList.remove("show");
});