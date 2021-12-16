function sendIdForm(id) {
    let viewCureForm = document.querySelector('#viewCureForm');
    viewCureForm[0].value = id;
    viewCureForm.submit();
}

function sendIdForDeleteForm(id) {
    let deleteCureForm = document.querySelector('#deleteCureForm');
    deleteCureForm[0].value = id;
    deleteCureForm.submit();
}

window.onload = () => {
    let input = document.querySelector('#search_cure');
    input.oninput = function () {
        let value = this.value.trim().toLowerCase();
        let list = document.querySelectorAll('.drug-form-container');
        if (value !== '') {
            list.forEach(elem => {
                const h1 = elem.querySelector("h1").innerHTML.toLowerCase()
                if (h1.search(value) === -1) {
                    elem.classList.add('hide')
                }
            });
        } else {
            list.forEach(elem => {
                elem.classList.remove('hide')
            })
        }

    }
}
