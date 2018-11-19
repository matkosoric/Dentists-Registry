$(document).ready(function() {
    $('#dataTable').DataTable(
    {
      "columnDefs": [
        {       "targets": [0, 3, 4, 5 ],
                "searchable": false  }
      ]
    } );

    $('a.delete').confirm({
        content: "Selected entry will be deleted!",
        columnClass: 'small/s',
        buttons: {
                    'OK': function () {
                        location.href = this.$target.attr('href');
                    },
                    'Cancel ': function () {               }
        }
    });
} );


