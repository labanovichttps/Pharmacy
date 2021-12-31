function app() {
    const buttons = document.querySelectorAll('.button')
    const cards = document.querySelectorAll('.drug-form-container')

    function filter(category, items){
        items.forEach((item) => {
            const isItemFiltered = !item.classList.contains(category)
            const isShowAll = category.toLowerCase() === 'all'
            if (isItemFiltered && !isShowAll){
                item.classList.add('hides')
            } else {
                item.classList.remove('hides')
            }
        })
    }

    buttons.forEach((button) => {
        button.addEventListener('click', () =>{
            const currentCategory = button.dataset.filter
            filter(currentCategory, cards)
        })
    })
}

app()