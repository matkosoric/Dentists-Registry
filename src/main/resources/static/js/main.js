$(document).ready(function() {
    $('#dataTable').DataTable(
    {
      "columnDefs": [
        {       "targets": [0, 3, 4, 5 ],
                "searchable": false  }
      ]
    } );

    $('a.delete').confirm({
        content: "Odabrani kontakt bit će izbrisan !",
        columnClass: 'small/s',
        buttons: {
                    'U redu': function () {
                        location.href = this.$target.attr('href');
                    },
                    'Odbaci ': function () {               }
        }
    });
} );


