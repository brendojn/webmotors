import chai from 'chai'
import chaiHttp from 'chai-http'
import * as constant from '../env'

chai.use(chaiHttp)

const request = chai.request(constant.URL_API)

const expect = chai.expect

describe("Validar valores do veículo honda city", () => {

    it('devo validar todos os modelos para a marca chevrolet ', (done) => {
        request
            .get("/Vehicles?Page=1")
            .end((err, res) => {
                expect(res).to.has.status(200);
                expect(res.body[0].Make).to.equal("Honda");
                expect(res.body[0].Model).to.equal("City");
                done()
            })
    })
})

describe("Validar se o ano de modelo dos veículos é sempre menor ou igual ao ano de fabricação", () => {

    it('todos os veiculos retornados pela request deve ter a fabricação menor ou igual ao ano de modelo ', (done) => {
        request
            .get("/Vehicles?Page=2")
            .end((err, res) => {
                expect(res).to.has.status(200);
                for (let i = 0; i < res.body.length; i++) {
                    expect(res.body[i].YearFab).to.lessThanOrEqual(res.body[i].YearModel);

                }
                done()
            })
    })
})


describe("Não passar a page", () => {

    it('devo receber uma mensagem de request inválida ', (done) => {
        request
            .get("/Vehicles?Page=")
            .end((err, res) => {
                expect(res).to.has.status(400);
                expect(res.body.Message).to.equal("The request is invalid.")
                done()
            })
    })
})




