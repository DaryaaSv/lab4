function toggleForm() {
    var executionType = document.getElementById('executionType').value;
    var functionForm = document.getElementById('functionForm');
    var procedureForm = document.getElementById('procedureForm');
    var sqlOption = document.getElementById('sqlOption');
    var functionContainers = document.querySelectorAll('.form-container[id$="Form"]');

    functionContainers.forEach(function (container) {
        container.classList.remove('active');
    });

    if (executionType === 'function') {
        functionForm.classList.add('active');
        sqlOption.innerHTML = getFunctionOptions();
        toggleOptionForm();
        // Set the method attribute for the function form
        document.getElementById('functionForm').setAttribute('method', 'post');
    } else {
        procedureForm.classList.add('active');
        sqlOption.innerHTML = getProcedureOptions();
        toggleOptionForm();
        // Set the method attribute for the procedure form
        document.getElementById('procedureForm').setAttribute('method', 'post');
    }
}

function toggleOptionForm() {
    var sqlOption = document.getElementById('sqlOption').value;
    var functionContainers = document.querySelectorAll('.form-container[id$="Form"]');
    functionContainers.forEach(function (container) {
        container.classList.remove('active');
    });

    var selectedForm = document.getElementById(sqlOption + 'Form');
    if (selectedForm) {
        selectedForm.classList.add('active');
    }
}

function getFunctionOptions() {
    return `
        <option value="FindMostExpensiveDoctor">FindMostExpensiveDoctor</option>
        <option value="GetSpentByPatient">GetSpentByPatient</option>
    `;
}

function getProcedureOptions() {
    return `
        <option value="AddAppointment">AddAppointment</option>
        <option value="UpdateDoctorSchedule">UpdateDoctorSchedule</option>
    `;
}
