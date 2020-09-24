

import axios from 'axios'

const url = 'http://localhost:8080'
const emp = `${url}/api/employee`

class ReteriveData {
    reterive(name) {

        return axios.get(`${emp}`)
    }
}

export default ReteriveData