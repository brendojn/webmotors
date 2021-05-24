import chai from 'chai'
import chaiHttp from 'chai-http'
import * as constant from '../env'

chai.use(chaiHttp)

const request = chai.request(constant.URL_API)

const expect = chai.expect

describe("Conferir marcas de veículos", () => {

    it('devo verificar se o status veio 200, assim como todas as marcas', (done) => {
        request
            .get("/Make")
            .end((err, res) => {
                expect(res).to.has.status(200);
                expect(res.body[0].Name).to.equal("Chevrolet");
                expect(res.body[1].Name).to.equal("Honda");
                expect(res.body[2].Name).to.equal("Ford");
                done()
            })
    })
})
