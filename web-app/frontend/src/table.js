

import React from 'react'

const table = () => {



    return <div>


        <table style={{ border: '1px solid black', borderCollapse: 'collapse' }}>
            <thead>
                <tr style={{ border: '1px solid black', borderCollapse: 'collapse' }}>
                    <th>User Id</th>
                    <th> email id </th>
                    <th>name</th>
                </tr>

                <tr>
                    <th>1</th>
                    <td>React@react.org</td>
                    <td>ReactJs</td>
                </tr>
            </thead>


        </table>
    </div>

}

export default table